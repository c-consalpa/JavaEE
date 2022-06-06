package xany.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import xany.models.Event;
import xany.models.User;

public class MappingsDemo {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Event.class)
                .buildSessionFactory();
        Session session = sf.getCurrentSession();

        try {

//            Event ev1 = new Event("sevas", "Sevastopol", 3);
                User user = new User();

            session.getTransaction().commit();



        } finally {
            sf.close();
        }
    }


}
