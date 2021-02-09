package consalpa;

import consalpa.aspects.SimpleProfiler;
import consalpa.dao.DAOImpl_Mock;
import consalpa.dao.NoSuchEntityException;
import consalpa.model.Product;
import consalpa.services.mService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "testServlet",urlPatterns = {"/testServlet"})
public class TestServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    // Load application context via .getRealPath()

        ApplicationContext ctx = new FileSystemXmlApplicationContext(getServletContext().getRealPath("/WEB-INF/appContext.xml"));
//        mService myBasicService = ctx.getBean("mService", consalpa.services.mService.class);
//        mService myBasicService_constr = ctx.getBean("mService_constructored", consalpa.services.mService.class);
//        myBasicService.serve();
//        myBasicService_constr.serve();
//        SimpleProfiler profiler = ctx.getBean("profiler", consalpa.aspects.SimpleProfiler.class);

        DAOImpl_Mock mockDAO = new DAOImpl_Mock();
        try {
            System.out.println(mockDAO.getProductByID(123));
        } catch (NoSuchEntityException e) {
            e.printStackTrace();
        }


    }
}
