
package c_consalpa.test_cart;

import c_consalpa.business.mCart;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "TestCart_Demo", urlPatterns = {"/Cart/TestCart_Demo"})
public class TestCart_Demo extends HttpServlet {
private final String SESSION_ATTR_CART = "mcart";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Cart/TestCart_Demo.jsp");
        Integer productId = Integer.valueOf(request.getParameter("id"));
        String cartAction = request.getParameter("act");
        
        if (cartAction == null || cartAction.isEmpty() || productId == null) {
            System.out.println("unsupported operation.");
            return;
        } 
        
        mCart cart;
        HttpSession session = request.getSession();
        cart = (mCart) session.getAttribute(SESSION_ATTR_CART);
        System.out.println("Retriveing cart from session: " + cart);
        if (cart == null) {
            cart = new mCart();
        }

        
        switch (cartAction) {
            case "add" : {
                System.out.println("ID: " + productId);
                System.out.println("cartAction: " + cartAction);
                cart.addProduct(productId);
                session.setAttribute(SESSION_ATTR_CART, cart);
                
                break;
            }
            case "remove" : {
                System.out.println("ID: " + productId);
               System.out.println("cartAction: " + cartAction);
               cart.removeProduct(productId);
               session.setAttribute(SESSION_ATTR_CART, cart);
               break;
            }
        }
                System.out.println(cart);
        

        
        requestDispatcher.forward(request, response);
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
