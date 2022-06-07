package xany.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import xany.models.User;
import xany.models.UserDetail;

public class MappingsDemo {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserDetail.class)
                .buildSessionFactory();
        Session session = sf.getCurrentSession();

        try {
        session.beginTransaction();


//
            User newTestUser = new User("Lana");
            UserDetail newTestUserDetail = new UserDetail("Rhoades@mail.com", "slut");


            // !!! - association between User and UserDetails:
            //  this saves both objects to db due to CascadeType.ALL:
            newTestUser.setUserDetail(newTestUserDetail);


//             INSERT:
             session.save(newTestUser);

            // DELETE:
//            User tmpUser = session.get(User.class, 16L);
//            if (tmpUser != null) {
//                session.delete(tmpUser);
//            }


//            UserDetail tmpUserDetail = session.get(UserDetail.class, 101L);
//            System.out.println(tmpUserDetail.getUser());
//            if (tmpUserDetail != null) {
//                session.delete(tmpUserDetail);
//            }


//            session.createSQLQuery("truncate table user_details").executeUpdate();
        session.getTransaction().commit();



        } catch (Exception e) {
            System.out.println("Closing Hibernate sesssion..");
            session.close();
        } finally
        {
            System.out.println("closing session");
            sf.close();
        }
    }


}
