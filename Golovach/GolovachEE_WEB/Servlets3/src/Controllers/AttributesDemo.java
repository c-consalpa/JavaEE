package Controllers;

import Models.MockModelA;
import Models.MockStorage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//SHows usage of setting Java types as request attributes
//See attributes.jsp for jsp syntax
@WebServlet("/attr")
public class AttributesDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MockModelA modelA = new MockModelA();
        request.setAttribute("modelA", modelA);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("attributes.jsp");
        requestDispatcher.forward(request, response);
    }
}
