package xany.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import xany.models.Comment;
import xany.models.User;
import xany.models.UserDetail;

public class One2ManyDemo {
        public static void main(String[] args) {
            SessionFactory sf = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(UserDetail.class)
                    .addAnnotatedClass(Comment.class)
                    .buildSessionFactory();

            Session session = sf.getCurrentSession();

            try {
                session.beginTransaction();


//                User tmpUser = new User("Lana");
//                UserDetail tmpUserDetails = new UserDetail("Lana@mail.com", "more");
//                tmpUser.setUserDetail(tmpUserDetails);
//                session.save(tmpUser);

                User usr = session.get(User.class, 1L);

                Comment c = new Comment("first comment for Lana");

                usr.addUserComment(c);


                session.save(c);
//                session.save(usr);








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
