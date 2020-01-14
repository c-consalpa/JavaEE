

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Ch2Servlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        java.util.Date today = new java.util.Date();
        out.println("<html> " +
                "<body>" +
                "<h1 style=\"text-align:center\">" +
                "HF's Chapter2 Servlet</h1>" +
                "<br>" + today +
                "</body>" +
                "</html>");
    }
}
