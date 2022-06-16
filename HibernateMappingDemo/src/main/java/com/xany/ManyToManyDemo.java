package com.xany;

import com.xany.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyDemo {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Lecturer.class)
                .addAnnotatedClass(LecturerDetails.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sf.getCurrentSession();

        try {
            // transacted
            session.beginTransaction();

//            Course c1 = new Course("Maven Practice");
//            Course c2 = new Course("second Course");
//            Course c3 = new Course("3 course");
//
//            session.save(c1);
//            session.save(c2);
//            session.save(c3);
////
//            Student st1 = new Student("John doe", "john@mail.com");
//            Student st2 = new Student("Nikolas Zalupipalas", "nick@mail.com");
//            Student st3 = new Student("Frank Shamrock", "frankie@mail.com");
//            Student st4 = new Student("Bill Gates", "wtd@mail.com");
//            Student st5 = new Student("DMitriy Ezhov", "ezh@mail.com");
//
//
//            c1.addStudent(st1);
//            c1.addStudent(st2);
//            c2.addStudent(st3);
//            c2.addStudent(st4);
//            c3.addStudent(st5);
//
//            session.save(st1);
//            session.save(st2);
//            session.save(st3);
//            session.save(st4);
//            session.save(st5);

//            Course course2Delete = session.get(Course.class, 3L);
//            session.delete(course2Delete);


//            Course newCourse = new Course("new Course for ezh");
//            session.save(newCourse);
            Student ezh = session.get(Student.class, 8L);

            Course cours4Ezh = session.get(Course.class, 9L);
                cours4Ezh.addStudent(ezh);
                session.save(cours4Ezh);









            session.getTransaction().commit();
            System.out.println("Exiting gracefully");
        } finally {
            sf.close();
        }
    }
}
