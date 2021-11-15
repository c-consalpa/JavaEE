package xany.mvc.Controllers;

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
        //create User object (POJO). Spring will pass this object along with the request.
        User user = new User();

        // "usr" is the model attribute of SpringMVC's <form:form modelAttribute>
        model.addAttribute("usr", user);

        return "form-tags";
    }


    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("usr") User theUser) {
        System.out.println(theUser.toString());
        return "user-confirm";
    }
}
