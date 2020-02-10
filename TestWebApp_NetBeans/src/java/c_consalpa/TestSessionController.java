/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_consalpa;

import Utils.CookieUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author c-consalpa
 */
@WebServlet(name = "TestSessionController", urlPatterns = {"/TestSessionController"})
public class TestSessionController extends HttpServlet {
static int counter = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Request received. Session: " + request.getSession().getId());
        counter++;
        System.out.println("Counter :" + counter);

        
//        HttpSession session = request.getSession();
//        request.setAttribute("ses", session.getId());
//        request.setAttribute("cnt", Integer.toString(counter));
////        Cookies:
//        System.out.println("Request has the following cookies:");
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//        for (Cookie c : cookies) {
//            if (c.getName().equals("customCookie")) counter++;
//            System.out.print(c.getName() + " : ");
//            System.out.println(c.getValue());
//            System.out.println("****");
//        }
//        }
//        request.setAttribute("cnt", Integer.toString(counter));
//        System.out.println("Setting custom cookie");
//        Cookie cookie = new Cookie("customCookie", "abc");
//        response.addCookie(cookie);
Cookie[] cookies = request.getCookies();




        
        
        
        
        
               if (counter > 3) {
//Utils.CookieUtils.invalidateCookies(request.getCookies());
  if (cookies != null) {
            for(Cookie c: cookies) {
                System.out.println("invalidating: " + c.getName());
               c.setMaxAge(0);
              
               response.addCookie(c);
            }
        }
        } else {
        Cookie cookie1 = new Cookie("customCookie1", "abc");
        response.addCookie(cookie1);
        Cookie cookie2 = new Cookie("customCookie2", "abc1");
        response.addCookie(cookie2);
        Cookie cookie3 = new Cookie("customCookie3", "3");
        response.addCookie(cookie3);
               }
        
               
               
               System.out.println(Utils.CookieUtils.listAllCookies(cookies));
         RequestDispatcher dsptchr = request.getRequestDispatcher("TestSessionView.jsp");
         dsptchr.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
