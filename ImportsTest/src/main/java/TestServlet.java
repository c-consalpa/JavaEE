import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String> testCollection = new HashMap<>();
        testCollection.put("foo", "bar");
        testCollection.put("foo1", "bar1");
        testCollection.put("foo2", "bar2");
        request.setAttribute("data", testCollection);

        Map<String, Integer> cart = new HashMap<>();
        cart.put("oil", 1);
        request.setAttribute("cart", cart);

        getServletContext().getRequestDispatcher("/testPage.jsp").forward(request, response);
    }
}
