package xany.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {

    // show form

    @RequestMapping("/showForm")
    public String showFormPage() {
        return "m-form";
    }


    // process form
    @RequestMapping("/processForm")
    public String processFormData() {
        return "home";
    }
}
