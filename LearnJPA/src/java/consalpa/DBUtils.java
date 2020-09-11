package consalpa;

import consalpa.business.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtils {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LearnJPAPU");
    
    public static EntityManagerFactory getEMFactory() {
        return emf;
    }
    
    
    public static User getUser() {
        EntityManager em = emf.createEntityManager();
        
        User usr = em.find(User.class, new Long(4));
        return usr;
    }
    
    
    
}
