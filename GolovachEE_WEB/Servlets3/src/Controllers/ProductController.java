package Controllers;

import DAO.Exceptions.EntityNotFoundException;
import DAO.ProductDAO_Mock;
import Exceptions.BadURLException;

import Models.MockStorage;
import Models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;


public class ProductController extends HttpServlet {
    static final String PARAM_ID = "id";
    static final String REQUEST_ATTRIBUTE_PRODUCT = "product";


    protected void doPost(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter(PARAM_ID);
        Product product = null;

        try {
            validateRequestParams(idStr);
        } catch (BadURLException e) {
            request.setAttribute("message", "bad URL");
            RequestDispatcher dsptch = request.getRequestDispatcher("error.jsp");
            e.printStackTrace();
            dsptch.forward(request, response);
            return;
        }
        processRequest(idStr, request, response);
    }

    private void validateRequestParams(String idStr) throws BadURLException {
        if (idStr == null || idStr.isEmpty()) {
            throw new BadURLException("Bad URL: No id or empty value");
        } else if (idStr.equals("all")) {
            return;
        }
//        Check for NumberFormatException
        try {
            Integer id = Integer.parseInt(idStr);
        } catch (NumberFormatException ex) {
            throw new BadURLException(ex.getMessage(), ex);
        }
    }

    private void processRequest(String idStr, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MockStorage mockStorage = new MockStorage();
        ProductDAO_Mock productDAO_mock = new ProductDAO_Mock();
        Product product = null;
        RequestDispatcher dsptch = request.getRequestDispatcher("product.jsp");

        if (idStr.equals("all")) {
            Map<Integer, String> products = productDAO_mock.selectAll();
            request.setAttribute("product_list", products.toString());
        } else {
            try {
                product = productDAO_mock.selectById(Integer.parseInt(idStr));
            } catch (EntityNotFoundException ex) {
                request.setAttribute("message", "no such product: " +idStr);
                dsptch = request.getRequestDispatcher("error.jsp");
            }
        }

        request.setAttribute(REQUEST_ATTRIBUTE_PRODUCT, product);
        dsptch.forward(request, response);
    }
}
