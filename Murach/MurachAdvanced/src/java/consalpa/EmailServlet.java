/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consalpa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author c-consalpa
 */
public class EmailServlet extends HttpServlet {
private static final String FROM        = "alpashkin.konsta@mail.ru";
private static final String TO          = "konstantin1.alpashkin@gmail.com";
private static final String FROM_PWD    = "bass655";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        Properties props = new Properties();
//        props.put("mail.transport.protocol", "smtps");
//        props.put("mail.smtps.host", "smtp.gmail.com");
//        props.put("mail.smtps.port", 465);
//        props.put("mail.smtps.auth", "true");
//        props.put("mail.smtps.quitwait", "false");


          props.put("mail.smtp.host", "smtp.mail.ru");
          props.put("mail.smtp.port", 465);
          props.put("mail.smtp.auth", true);
          props.put("mail.smtp.starttls.enable", true);
          props.put("mail.smtp.quitwait", false);
          props.put("mail.smtp.ssl.enable", "true");


//        Session emailSession = Session.getDefaultInstance(props);
        Session emailSession = Session.getInstance(props,
                new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM, FROM_PWD); //To change body of generated methods, choose Tools | Templates.
            }

                }
                );
        emailSession.setDebug(true);
        
        
        Message msg = new MimeMessage(emailSession);
        Address fromAddress, toAddress = null;
        
       try {
            msg.setSubject("testSubject");
            msg.setText("htmlText");
//            msg.setContent("<a href=\"#\">test</a>", "text/html");
            
            fromAddress = new InternetAddress("alpashkin.konsta@mail.ru");
            toAddress = new InternetAddress(TO);
            msg.setFrom(fromAddress);
            msg.setRecipient(Message.RecipientType.TO, toAddress);
                    
            
            
//            Transport transport = emailSession.getTransport();
//            transport.connect(FROM, FROM_PWD);
//            transport.sendMessage(msg, msg.getAllRecipients());

Transport.send(msg);
            
//            transport.close();
        } catch (MessagingException ex) {
            Logger.getLogger(EmailServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        

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
