package consalpa;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "testServlet",urlPatterns = {"/testServlet"})
public class TestServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

//        PrintWriter pw = new PrintWriter(response.getOutputStream());
//        pw.print("<html><head></head><body>hello</body></html>");
//        pw.flush();
    }
}
