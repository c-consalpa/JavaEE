package xany.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import xany.mvc.models.User;

@Controller
@RequestMapping("form-tags")
public class FormTagsDemoController {

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        //create User object
        User user = new User();
        // "m_user" is the modelattribute of SpringMVC'f <form:form modelAttribute>
        model.addAttribute("usr", user);
        return "form-tags";
    }


    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("usr") User theUser) {
        System.out.println(theUser.toString());
        return "user-confirm";
    }
}
