/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consalpa;

import consalpa.business.Phone;
import consalpa.business.User;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "mServlet", urlPatterns = {"/mServlet"})
public class mServlet extends HttpServlet {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LearnJPAPU");
    
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {

                       EntityManager em = emf.createEntityManager();
                       Phone phone = em.find(Phone.class, 5L);
                       System.out.println(phone);
                       
                       User usr = new User();
                       usr.setId(99L);
                       usr.setUserName("NOTKEVIIN1");
                       
                       
                       User usr1 = new User();
                       usr1.setId(99L);
                       usr1.setUserName("NOTKEVIIN1");
                       
                       EntityTransaction trans = em.getTransaction();
                       trans.begin();
                       //em.remove(em.merge(usr));
                       
                       
                       trans.commit();
                       
                       
        
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
