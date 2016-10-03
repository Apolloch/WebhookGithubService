import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;

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
        File log = new File("testReq");
        FileWriter fileWriter = new FileWriter(log);
        Enumeration<String> headerNames = req.getHeaderNames();
        while (!headerNames.hasMoreElements()){
            fileWriter.write(headerNames.nextElement());
        }
        fileWriter.close();
    }
}
