package consalpa;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DemoServlet", urlPatterns = "/DemoServlet")
public class DemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println(request.getParameter("postdata"));


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getParameter("getData"));

    }


}
