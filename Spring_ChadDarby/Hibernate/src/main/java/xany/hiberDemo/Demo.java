package xany.hiberDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import xany.models.Event;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Event.class)
                        .buildSessionFactory();
        Session session = sf.getCurrentSession();

        try {
            // transacted
            session.beginTransaction();


            session.getTransaction().commit();
        } finally {
            sf.close();
        }
    }
}
