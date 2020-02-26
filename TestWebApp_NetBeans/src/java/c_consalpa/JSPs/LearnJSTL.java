/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_consalpa.JSPs;

import c_consalpa.business.mProduct;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author c-consalpa
 */
@WebServlet(name = "LearnJSTL", urlPatterns = {"/LearnJSTL"})
public class LearnJSTL extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        String script = "<script>alert(0);</script>";
        Map<String, mProduct> testMap = new HashMap();
        
        
        mProduct p1 = new mProduct();
        p1.setId(6540);
        p1.setValue("6540 is the value");
        testMap.put("one", p1);
        mProduct p2 = new mProduct();
        p2.setId(2222);
        p2.setValue("2222 is the value");
        testMap.put("two", p2);
        
        String tokenizedString ="a|C\\Asd|asd\\s|1\\2\\|2|#3| ";
        request.setAttribute("tokenizedString", tokenizedString);
        
        int[] nums = new int[30];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        
        request.setAttribute("nums", nums);
        
        
        
        request.setAttribute("script", script);
        request.setAttribute("testMap", testMap);
        
        
        this.getServletContext().getRequestDispatcher("/LearnJSTL.jsp").forward(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
;