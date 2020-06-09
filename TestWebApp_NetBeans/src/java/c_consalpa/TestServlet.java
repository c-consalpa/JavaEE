package c_consalpa;

import c_consalpa.business.mUser;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");        

//Get parameters Map
//            Map<String, String[]> parameters = request.getParameterMap();
//            for (Map.Entry<String, String[]> p : parameters.entrySet()) {
//                System.out.println("PARAM : " + p.getKey());
//                System.out.println("VALUE: " + Arrays.toString(p.getValue()));
//            }

//            List Headers:
//             for (Enumeration e = request.getHeaderNames(); e.hasMoreElements();) {
//                 String header = e.nextElement().toString();
//                    System.out.println(header + " : " + request.getHeader(header));
//                    
//             }
       

//  Locate file on server's file system
// String str = getServletContext().getRealPath("/WEB-INF/1.txt");
// File f = new File(str);
//        System.out.println(f.getPath());
// System.out.println(f.length());


//        String param_hid = request.getParameter("param_hid");
//        System.out.println("param_hid: " + param_hid);
//        String hiddenInput = request.getParameter("hiddenInput");
//        System.out.println("param_hid:" + hiddenInput);


mUser user = new mUser();
user.setName("testName");
request.setAttribute("user", user);



ServletContext ctx = getServletContext();
ctx.getRequestDispatcher("/forwarded.jsp").forward(request, response);

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
        response.setContentType("text/html;charset=UTF-8");
        processRequest(request ,response);
        
        
        
        
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
