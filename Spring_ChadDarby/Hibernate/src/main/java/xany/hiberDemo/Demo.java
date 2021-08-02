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
            Event ev = new Event("pohod", "bakhch", 50);
            Event ev1 = new Event("sevas", "Sevastopol", 3);

            // transacted
            session.beginTransaction();

            // INSERT:
//            session.save(ev);
//            session.save(ev1);


            // GET:
//            Event retrievedEv = session.get(Event.class, ev.getId());
//            System.out.println(retrievedEv);

            // QUERY:
//            List<Event> eventList = session
//                    .createQuery("from Event s where s.id = 3")
//                    .getResultList();

            // TRUNCATE:
//            session.createSQLQuery("truncate table event").executeUpdate();


            // UPDATE
            // via JPA relations:
            Event eventR = session.get(Event.class, 2);
//            eventR.setEventLocation("pereezhaem");

            // via low HQL
//            session.createQuery("update Event set eventLocation='Pravdy, 33'").executeUpdate();
//            System.out.println(eventList);

            // DELETE
            session.delete(eventR);

            session.createQuery("delete from Event where eventLocation='Pravdy, 33'").executeUpdate();


            session.getTransaction().commit();



        } finally {
            sf.close();
        }
    }
}
