package fr.univlille1.m2iagl.bacquetdurey.webhook;

import fr.univlille1.m2iagl.bacquetdurey.main.Start;
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
        resp.getWriter().write("coucou github");
        File f = new File("testReq");
        FileInputStream fileInputStream = new FileInputStream(f);
        resp.getWriter().write(fileInputStream.read());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("coucou post");
        StringBuilder builder = new StringBuilder();
        String aux = "";

        while ((aux = req.getReader().readLine()) != null) {
            builder.append(aux);
        }

        String text = builder.toString();
        try {
            JSONObject json = new JSONObject(text);
            //for a push request
                //String archive_url = json.getJSONObject("repository").getString("archive_url");
                //archive_url=archive_url.replace("{archive_format}{/ref}","");

            String pull_request_archive_url = json.getJSONObject("pull_request").getJSONObject("head").getJSONObject("repo").getString("archive_url");
            pull_request_archive_url=pull_request_archive_url.replace("{archive_format}{/ref}","");
            String pull_request_ref = json.getJSONObject("pull_request").getJSONObject("head").getString("ref");
            String base_archive_url = json.getJSONObject("pull_request").getJSONObject("base").getJSONObject("repo").getString("archive_url");
            base_archive_url=base_archive_url.replace("{archive_format}{/ref}","");
            String base_ref = json.getJSONObject("pull_request").getJSONObject("base").getString("ref");
            URL pull_request_url= new URL(pull_request_archive_url + "zipball/" + pull_request_ref);
            URL base_url= new URL(base_archive_url + "zipball/" + base_ref);
            File pull_request_archive = HttpDownloadUtility.downloadFile(pull_request_url.toString(),Config.TMP_DIR);
            File base_archive = HttpDownloadUtility.downloadFile(base_url.toString(),Config.TMP_DIR);
            File finalPRDir = UnzipUtility.unzip(pull_request_archive.getAbsolutePath(),Config.TMP_DIR);
            File finalBaseDir = UnzipUtility.unzip(base_archive.getAbsolutePath(),Config.TMP_DIR);
            base_archive.delete();
            pull_request_archive.delete();
            //FileUtils.deleteDirectory(finalPRDir);
            try {
                Start.main(new String[]{""});
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
