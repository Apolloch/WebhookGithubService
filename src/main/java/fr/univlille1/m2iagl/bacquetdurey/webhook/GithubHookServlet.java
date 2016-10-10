package fr.univlille1.m2iagl.bacquetdurey.webhook;

import fr.univlille1.m2iagl.bacquetdurey.main.Start;
import org.apache.commons.io.FileUtils;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;

/**
 * Created by bacquet on 03/10/16.
 */
public class GithubHookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Result of the javadoc analyse of the push request\n\n");
        try {
            BufferedReader br = new BufferedReader(new FileReader(Config.RESULT_DIRECTORY+Config.RESULT_FILE_NAME));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String result = sb.toString();
            resp.getWriter().write(result);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            resp.getWriter().write("file not found");

        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("coucou post");
        StringBuilder builder = new StringBuilder();
        String aux = "";
        File finalPRDir = null;
        File finalBaseDir = null;

        while ((aux = req.getReader().readLine()) != null) {
            builder.append(aux);
        }

        String text = builder.toString();
        try {
            JSONObject json = new JSONObject(text);
            getSourcesDirs(json,finalPRDir,finalBaseDir);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getSourcesDirs(JSONObject json,File finalPRDir,File finalBaseDir) throws JSONException, IOException {
        File[] dircontent = new File(Config.RESULT_DIRECTORY).listFiles();
        for (File f: dircontent) {
            if(f.isDirectory())
                FileUtils.deleteDirectory(f);
        }
        String pull_request_archive_url = json.getJSONObject("pull_request").getJSONObject("head").getJSONObject("repo").getString("archive_url");
        pull_request_archive_url=pull_request_archive_url.replace("{archive_format}{/ref}","");
        String pull_request_ref = json.getJSONObject("pull_request").getJSONObject("head").getString("ref");

        String base_archive_url = json.getJSONObject("pull_request").getJSONObject("base").getJSONObject("repo").getString("archive_url");
        base_archive_url=base_archive_url.replace("{archive_format}{/ref}","");
        String base_ref = json.getJSONObject("pull_request").getJSONObject("base").getString("ref");

        URL pull_request_url= new URL(pull_request_archive_url + "zipball/" + pull_request_ref);
        URL base_url= new URL(base_archive_url + "zipball/" + base_ref);

        File pull_request_archive = HttpDownloadUtility.downloadFile(pull_request_url.toString(), Config.TMP_DIR);
        File base_archive = HttpDownloadUtility.downloadFile(base_url.toString(),Config.TMP_DIR);


        finalPRDir = UnzipUtility.unzip(pull_request_archive.getAbsolutePath(), Config.TMP_DIR);
        finalBaseDir = UnzipUtility.unzip(base_archive.getAbsolutePath(), Config.TMP_DIR);
        finalBaseDir.renameTo(new File(Config.RESULT_DIRECTORY+Config.MASTER_BRANCH_DIR_NAME));
        finalPRDir.renameTo(new File(Config.RESULT_DIRECTORY+Config.PULL_REQUEST_DIR_NAME));
        clearArchives(pull_request_archive, base_archive);


        //Start.startAnalyse(finalBaseDir.getAbsolutePath(),finalPRDir.getAbsolutePath());
    }

    private void clearArchives(File pull_request_archive, File base_archive) {
        base_archive.delete();
        pull_request_archive.delete();
    }
}
