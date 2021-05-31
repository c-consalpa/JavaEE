package consalpa;

import consalpa.aspects.SimpleProfiler;
import consalpa.dao.MockDAO;
import consalpa.dao.mDao;
import consalpa.model.Product;
import consalpa.services.BaseService;
import consalpa.services.mService;
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

        ApplicationContext ctx = new FileSystemXmlApplicationContext(getServletContext().getRealPath("/WEB-INF/appContext.xml"));
        ApplicationContext ctx_ann = new FileSystemXmlApplicationContext(getServletContext().getRealPath("/WEB-INF/appContext_Annotated.xml"));


//        mService myBasicService = ctx.getBean("baseService", consalpa.services.mService.class);
//        myBasicService.serve();
//
//        mService myBasicService_constr = ctx.getBean("baseService_constructor", consalpa.services.BaseService_InitConstructor.class);
//        myBasicService_constr.serve();
//
//        mService myBasicService_setters = ctx.getBean("baseService_setters", consalpa.services.BaseService_Setters.class);
//        myBasicService_setters.serve();
//
//        mDao mockDAO = ctx.getBean("mockDAO", MockDAO.class);
//        SimpleProfiler profiler = ctx.getBean("aspectProfiler", consalpa.aspects.SimpleProfiler.class);
//        List<Product> list = mockDAO.getAllProducts();


        BaseService bs = (BaseService) ctx_ann.getBean("baseService");
        bs.serve();


    }
}
