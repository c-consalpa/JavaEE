package consalpa.Controllers;

import consalpa.Components.mCart;
import consalpa.Data.DAO.MockStorageDAOImpl;
import consalpa.Data.MockStorage;
import consalpa.Exceptions.NoSuchEntityException;
import consalpa.Model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext ctx = getServletContext();

        String action = request.getParameter("action");

        // init products
        MockStorage mockStorage = new MockStorage();
        MockStorageDAOImpl mockStorageDAO = new MockStorageDAOImpl(mockStorage);
        HashSet<Product> products = mockStorageDAO.getAllProducts();
        request.setAttribute("products", products);

        // init session
        HttpSession session = request.getSession();
        mCart mCart = (consalpa.Components.mCart) session.getAttribute("mcart");

        if (mCart == null) {
            mCart = new mCart();
        }

        if (action != null && !action.isEmpty()) {
            Product tmpProduct = null;
            int productID = 0;

            try {
                productID = Integer.parseInt(request.getParameter("productId"));
            } catch (NumberFormatException ex) {
                System.out.println("cannot parse product ID");
            }

            switch (action) {
                case "add" :
                    try {
                        tmpProduct = mockStorageDAO.getProductByID(productID);
                    } catch (NoSuchEntityException e) {
                        e.printStackTrace();
                    }

                    mCart.add2Cart(tmpProduct);
                    session.setAttribute("mcart", mCart);
                    ctx.getRequestDispatcher("/productPage.jsp").forward(request,response);
                    return;

                case "view":
                    try {
                        tmpProduct = mockStorageDAO.getProductByID(productID);
                    } catch (NoSuchEntityException e) {
                        e.printStackTrace();
                    }
                    request.setAttribute("product", tmpProduct);
                    ctx.getRequestDispatcher("/productDetails.jsp").forward(request,response);
                    return;
                case "delete":
                    try {
                        tmpProduct = mockStorageDAO.getProductByID(productID);
                    } catch (NoSuchEntityException e) {
                        e.printStackTrace();
                    }


                    session.setAttribute("mcart", mCart.removeItemFromCart(tmpProduct));
            }
        }

        ctx.getRequestDispatcher("/productPage.jsp").forward(request,response);
    }
}
