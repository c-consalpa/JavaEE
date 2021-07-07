package xany.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


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

    @RequestMapping("/processFormModel")
    public String testModelData(HttpServletRequest request, Model model) {
        String param = request.getParameter("q");
        model.addAttribute("modelAttr", param);
        return "home";
    }
}
