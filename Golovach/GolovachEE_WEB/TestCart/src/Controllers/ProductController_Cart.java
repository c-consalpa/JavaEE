package Controllers;

import DAO.Exceptions.EntityNotFoundException;
import DAO.ProductDAO_Mock;
import Models.Cart;
import Models.MockStorage;
import Models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ProductController_Cart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String add = request.getParameter("add");


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("productView.jsp");
        DAO.ProductDAO_Mock productDAO_mock = new ProductDAO_Mock();

        Product product = null;
        try {
            product = productDAO_mock.selectById(Integer.parseInt(id));
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
        if (product != null) {
            request.setAttribute("product", product);
            if (add != null) {
//                add to cart:
                HttpSession ses = request.getSession();
                Cart cart = (Cart) ses.getAttribute("cart");
                if (cart == null) {
                    cart = new Cart();
                }
                ses.setAttribute("cart", cart.add(product, ses));
            }
        }




        requestDispatcher.forward(request, response);

    }



}
