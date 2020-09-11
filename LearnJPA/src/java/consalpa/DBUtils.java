package consalpa;

import consalpa.business.City;
import consalpa.business.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
        getCitiesList();
        return usr;
    }
    
    public static List<City> getCitiesList() {
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT i FROM City i WHERE i.cityName = 'simf'";
        
        TypedQuery<City> q = em.createQuery(jpql, City.class);
        List<City> citiesList = q.getResultList();
        if (citiesList == null || citiesList.size() == 0) {
            try {
                throw new Exception("kakayato huynya");
            } catch (Exception ex) {
                Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        em.close();
        return citiesList;
    }
    
}
