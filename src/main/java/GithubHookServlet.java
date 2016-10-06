import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;

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

            String archive_url = json.getJSONObject("repository").getString("archive_url");
            archive_url=archive_url.replace("{archive_format}{/ref}","");
            String ref = json.getString("ref");
            System.out.println(ref);
            URL url = new URL(archive_url + "zipball/" + ref);
            System.out.println(url);
            File archive = HttpDownloadUtility.downloadFile(url.toString(),"/home/m2iagl/bacquet/Documents/tmp");
            UnzipUtility.unzip(archive.getAbsolutePath(),"/home/m2iagl/bacquet/Documents/tmp");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
