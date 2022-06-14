package com.xany;

import com.xany.entity.Course;
import com.xany.entity.Lecturer;
import com.xany.entity.LecturerDetails;
import com.xany.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingsDemo {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(LecturerDetails.class)
                .addAnnotatedClass(Lecturer.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session = sf.getCurrentSession();

        try {
            // transacted
            session.beginTransaction();

            LecturerDetails lect1Details = new LecturerDetails("igor@mail.com");
            Lecturer l1 = new Lecturer("Igor");
            l1.setLecturerDetails(lect1Details);
            session.save(l1);

            Lecturer tmp = session.get(Lecturer.class, 1l);
            Review r = new Review();
            r.setReviewText("reviewA");
            Course c = new Course("jerking in a nutshell");
            c.addReview(r);



//            LecturerDetails lect1Details2 = new LecturerDetails("maxx@mail.com");
//            Lecturer l2 = new Lecturer("Max");
//            l2.setLecturerDetails(lect1Details2);
//            session.save(l2);







            tmp.addCourse(c);
            session.save(c);

            Course c1 = new Course("Java for mortals");
            Review review4JavaForMortals = new Review();
            review4JavaForMortals.setReviewText("Java for mortals - sucks");
            c1.addReview(review4JavaForMortals);
            tmp.addCourse(c1);
            session.save(review4JavaForMortals);
            session.save(c1);

            Course c2 = new Course("Guava");
            Lecturer lecturer2 = session.get(Lecturer.class, 3L);
            lecturer2.addCourse(c2);
            session.save(c2);







            Lecturer managedLecturer = session.get(Lecturer.class, 3L);
            System.out.println(managedLecturer);




            session.getTransaction().commit();



            System.out.println("Exiting gracefully");
        } finally {
            sf.close();
        }
    }
}
