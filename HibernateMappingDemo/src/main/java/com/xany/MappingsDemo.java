package com.xany;

import com.xany.entity.Course;
import com.xany.entity.Lecturer;
import com.xany.entity.LecturerDetails;
import com.xany.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

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

//            add Lecturers:

//            Lecturer l1 = new Lecturer("Igor");
//            LecturerDetails lDetails1 = new LecturerDetails("igor@mail.com");
//            l1.setLecturerDetails(lDetails1);
//            session.save(l1);
//
//            Lecturer l2 = new Lecturer("Max");
//            LecturerDetails lDetails2 = new LecturerDetails("maxx@mail.com");
//            l2.setLecturerDetails(lDetails2);
//            session.save(l2);
//
//            Lecturer l3 = new Lecturer("John");
//            LecturerDetails lDetails3 = new LecturerDetails("jjj@mail.com");
//            l3.setLecturerDetails(lDetails3);
//            session.save(l3);
//
//

//            add course+review:

//            Review r = new Review();
//            r.setReviewText("Eckel is best");
//            Course c = new Course("Thinking in java");
//            c.addReview(r);
//            session.save(c);

//            bind course to the review:

//            tmpLecturer.addCourse(c);
//            session.save(tmpLecturer);

//            session.delete(tmpLecturer);





//            Course course2Delete = session.get(Course.class, 7L);
//            session.delete(course2Delete);

//            Review tmpReview = session.get(Review.class, 11L);
//            if (tmpReview != null) session.delete(tmpReview);
//            Lecturer tmpLecturer = session.get(Lecturer.class, 1L);
//            tmpLecturer.setCourses(new ArrayList<>());
//            session.delete(tmpLecturer);
//            Course tmpCourse = session.get(Course.class, 10L);
//            session.delete(tmpCourse);
//            r.setReviewText("THinking is Java is the best starter book");
//            tmpCourse.addReview(r);
//            session.save(tmpCourse);


//
//            Course c = new Course("jerking in a nutshell");
//            c.addReview(r);
//            c.addReview(r1);
//            session.save(c);
//
//
//            tmp.addCourse(c);
//            session.save(tmp);

//            Course tmp = session.get(Course.class, 1L);
//            session.delete(tmp);

////            LecturerDetails lect1Details2 = new LecturerDetails("maxx@mail.com");
////            Lecturer l2 = new Lecturer("Max");
////            l2.setLecturerDetails(lect1Details2);
////            session.save(l2);
//
//
//
//
//
//
//
//            tmp.addCourse(c);
//            session.save(c);
//
//            Course c1 = new Course("Java for mortals");
//            Review review4JavaForMortals = new Review();
//            review4JavaForMortals.setReviewText("Java for mortals - sucks");
//            c1.addReview(review4JavaForMortals);
//            tmp.addCourse(c1);
//            session.save(review4JavaForMortals);
//            session.save(c1);
//
//            Course c2 = new Course("Guava");
//            Lecturer lecturer2 = session.get(Lecturer.class, 3L);
//            lecturer2.addCourse(c2);
//            session.save(c2);
//
//
//
//
//
//
//
//            Lecturer managedLecturer = session.get(Lecturer.class, 3L);
//            System.out.println(managedLecturer);




            session.getTransaction().commit();



            System.out.println("Exiting gracefully");
        } finally {
            sf.close();
        }
    }
}
