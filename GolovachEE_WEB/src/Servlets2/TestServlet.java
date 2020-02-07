package Servlets2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.servlet.http.*;


public class TestServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        OutputStream os = response.getOutputStream();
        response.setContentType("text/html");
        PrintWriter pw = new PrintWriter(os);
        pw.println("<h1>qweqweqe</h1>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<h1>qweqweqe</h1>");
        pw.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <title>Document</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "  \n" +
                "</body>\n" +
                "</html>");
    }
}
