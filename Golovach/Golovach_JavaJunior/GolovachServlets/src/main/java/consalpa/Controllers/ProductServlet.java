package consalpa.Controllers;

import consalpa.Components.mCart;
import consalpa.Data.DAO.MockStorageDAOImpl;
import consalpa.Data.MockStorage;
import consalpa.Model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewProduct = request.getParameter("viewProduct");
        System.out.println(viewProduct);
        // init products
        MockStorage mockStorage = new MockStorage();
        MockStorageDAOImpl mockStorageDAO = new MockStorageDAOImpl(mockStorage);
        List<Product> products = mockStorageDAO.getAllProducts();
        request.setAttribute("products", products);

        // init session
        HttpSession session = request.getSession();
        mCart mCart = (consalpa.Components.mCart) session.getAttribute("cart");
        if (mCart == null) {
            mCart = new mCart();
        }
        String action = request.getParameter("action");

        if (action != null && !action.isEmpty()) {
            switch (action) {
                case "add" :
                    System.out.println("add");
                    break;
                case "delete" :
                    System.out.println("add");
                    break;
                case "clear":
                    System.out.println("add");
                    break;
            }
        }




        this.getServletContext().getRequestDispatcher("/productPage.jsp").forward(request,response);

    }
}
