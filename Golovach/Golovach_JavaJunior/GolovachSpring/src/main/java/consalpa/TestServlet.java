package consalpa;

import consalpa.dao.MockDAO;
import consalpa.dao.mDao;
import consalpa.model.Product;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "testServlet",urlPatterns = {"/testServlet"})
public class TestServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Load application context via .getRealPath()

        ApplicationContext ctx = new FileSystemXmlApplicationContext(getServletContext().getRealPath("/WEB-INF/appContext_issue.xml"));
//        ApplicationContext ctx = new FileSystemXmlApplicationContext(getServletContext().getRealPath("/WEB-INF/applicationContextExample.xml"));
//        Operation op = (Operation) ctx.getBean("opBean");
//        System.out.println("calling msg...");
//        op.msg();
//        System.out.println("calling m...");
//        op.m();
//        System.out.println("calling k...");
//        op.k();
//        mService myBasicService = ctx.getBean("mService", consalpa.services.mService.class);
//        mService myBasicService_constr = ctx.getBean("mService_constructored", consalpa.services.mService.class);
//        myBasicService.serve();
//        myBasicService_constr.serve();
//        SimpleProfiler profiler = ctx.getBean("profiler", consalpa.aspects.SimpleProfiler.class);

        mDao mockDAO = ctx.getBean("mockDAO", MockDAO.class);

        List<Product> list = mockDAO.getAllProducts();
        System.out.println(list);


    }
}
