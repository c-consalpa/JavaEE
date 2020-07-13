/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_consalpa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.tribes.util.Arrays;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 *
 * @author c-consalpa
 */
@WebServlet(name = "TestCookieController", urlPatterns = {"/TestCookieController"})
public class TestCookieController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("a");
        
        Enumeration headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headerName = (String) headers.nextElement().toString(); 
            
            System.out.println(headerName + " : " + request.getHeader(headerName));
            
            
            
           
        }
        System.out.println("////");
        Cookie c = new Cookie("testCookie", "testValue");
        c.setComment("testPurpose");
        c.setValue("newValue");
        c.setPath("http://localhost:8080/TestWebApp_NetBeans/TestCookieController");
        response.addCookie(c);
        Cookie[] cooks = request.getCookies();
        System.out.println(Arrays.toString(cooks));
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
    }// </editor-fold>

}
