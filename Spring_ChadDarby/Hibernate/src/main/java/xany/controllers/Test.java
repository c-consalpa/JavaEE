package xany.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xany.models.Event;

@Controller
public class Test {

    @RequestMapping("test")
    public String testMethod(@RequestParam("foo") String param, Model model) {

        model.addAttribute("mAttrKey", param);
        return "test";
    }


    @RequestMapping("add")
    public String testMethod(@RequestParam("evname") String eventName,
                             @RequestParam("evcnt") String eventCount,
                             @RequestParam("evloc") String eventLocation,
                             Model model) {

        model.addAttribute("evname", eventName);
        model.addAttribute("evcnt", eventCount);
        model.addAttribute("evloc", eventLocation);



        return "test";
    }

    @RequestMapping("dropEvents")
    public String testMethod() {


        SessionFactory sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Event.class)
                .buildSessionFactory();
        Session session = sf.getCurrentSession();

        try {
            session.beginTransaction();
            session.createSQLQuery("truncate table event").executeUpdate();
            session.getTransaction().commit();
        } finally {
            sf.close();
        }

        System.out.println("TRUNCATING!");
        return "test";
    }
}
