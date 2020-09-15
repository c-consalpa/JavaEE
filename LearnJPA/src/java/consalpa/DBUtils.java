package consalpa;

import consalpa.business.City;
import consalpa.business.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DBUtils {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LearnJPAPU");
    
    public static EntityManagerFactory getEMFactory() {
        return emf;
    }
    
    
    public static User getUser() {
        EntityManager em = emf.createEntityManager();
        User usr = em.find(User.class, new Long(4));
        em.close();
        
        return usr;
    }
    
    public static List<User> getUsers() {
        List<User> userList = null;
        EntityManager em = null;
        
        try {   
            em = emf.createEntityManager();
            String jpql = "SELECT u FROM User u WHERE u.userId > :usrID";
            TypedQuery<User> q = em.createQuery(jpql, User.class);
            q.setParameter("usrID", 1L);
            userList = q.getResultList();
        
            if (userList == null || userList.size() == 0) {
                try {
                    throw new Exception("kakayato huynya");
                } catch (Exception ex) {
                    Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } finally {
            if (em != null) {
                em.close();    
            }
        }
            return userList;
        }
        
        
   public static int deleteUser_Transacted(User u) {
       if (u == null){
           System.out.println("No such user: null");
           return 0;
       }
       int cnt = 0;
       EntityManager em = emf.createEntityManager();
       EntityTransaction et = em.getTransaction();
       // Transaction:
       try {
           et.begin();
           em.remove(em.merge(u));
           
           et.commit();
       } catch(Exception ex) {
           System.out.println(ex.getMessage());
       }finally {
           em.close();
       }
       return 0;
   }
    
}
