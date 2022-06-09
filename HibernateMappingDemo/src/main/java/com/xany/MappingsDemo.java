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

//            LecturerDetails lect1Details = new LecturerDetails("igor@mail.com");
//            Lecturer l1 = new Lecturer("Igor");
//            l1.setLecturerDetails(lect1Details);
//            session.save(l1);
//
//            LecturerDetails lect1Details2 = new LecturerDetails("maxx@mail.com");
//            Lecturer l2 = new Lecturer("Max");
//            l2.setLecturerDetails(lect1Details2);
//            session.save(l2);
//
//            Course c = new Course("jerking in a nutshell");


            Lecturer tmp = session.get(Lecturer.class, 1l);
//            tmp.addCourse(c);
//            session.save(c);
//            l1.addCourse();
            tmp.getCourses();
            tmp.getLecturerDetails();
            System.out.println(1);









            session.getTransaction().commit();
            System.out.println("Exiting gracefully");
        } finally {
            sf.close();
        }
    }
}
