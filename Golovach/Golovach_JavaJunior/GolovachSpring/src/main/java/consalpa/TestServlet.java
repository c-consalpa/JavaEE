package consalpa;

import consalpa.services.mService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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

        System.out.println(getServletContext().getRealPath("/WEB-INF/appContext.xml"));

         ApplicationContext ctx = new FileSystemXmlApplicationContext(getServletContext().getRealPath("/WEB-INF/appContext.xml"));
         mService myBasicService = ctx.getBean("mService", consalpa.services.mService.class);
        System.out.println(myBasicService.serve());

//        PrintWriter pw = new PrintWriter(response.getOutputStream());
//        pw.print("<html><head></head><body>hello</body></html>");
//        pw.flush();
    }
}
