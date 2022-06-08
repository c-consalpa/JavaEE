package xany.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
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


                // Create 2 Users:
//                User user1 = new User("Josh");
//                UserDetail tmpUserDetails = new UserDetail("Qqqq@mail.com", "dev");
//                user1.setUserDetail(tmpUserDetails);
//                session.save(user1);
//
//                User user2 = new User("Tim");
//                UserDetail userDetail2 = new UserDetail("tim@mail.com", "qa");
//                user2.setUserDetail(userDetail2);
//                session.save(user2);
//
//
//                // Get user object from DB or reuse Users from  ^
//                 User usr = session.get(User.class, 1L);
//
////                // Create comments:
//                Comment c1 = new Comment("comment for " + usr.getUserName());
//                // associate comment with a user:
//                usr.addUserComment(c1);
//                // actually store in db:
//                session.save(c1);
//
//
//                Comment c2 = new Comment("2 comment for " + user1.getUserName());
//                user1.addUserComment(c2);
//                session.save(c2);



//                Comment c3 = new Comment("first comment for " + user2.getUserName());
//                user2.addUserComment(c3);
//                session.save(c3);
//
//
//                Comment c4 = new Comment("2 comment for " + user2.getUserName());
//                user2.addUserComment(c4);
//                session.save(c4);



//                // delete comment:
//                Comment comment2delete = session.get(Comment.class, 1L);
//                session.delete(comment2delete);
//                session.flush();
//
//                // stdout comments for a user:
                User tmpUser = session.get(User.class, 1L);
                System.out.println(tmpUser);

//
//
//                User tmpUser = session.get(User.class, 1L);
//                System.out.println(tmpUser.getComments());


                // The session is closed here. to work with DB data after session is closed:
                Query<User> query = session.createQuery("select i from User i JOIN FETCH i.comments where i.id=:theUserId", User.class);
                query.setParameter("theUserId", 1L);
                User usr = query.getSingleResult();

                session.getTransaction().commit();
                session.close();



                System.out.println(usr.getComments());

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Closing Hibernate session..");
                session.close();

            } finally {
                System.out.println("closing session");
                sf.close();
            }
        }


    }
