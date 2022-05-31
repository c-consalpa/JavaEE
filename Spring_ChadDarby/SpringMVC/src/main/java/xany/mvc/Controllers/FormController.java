package xany.mvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class FormController {

    // show form
    @RequestMapping("/showForm")
    public String showFormPage() {
        return "m-form";
    }


    // process a form
    @RequestMapping("/processForm")
    public String processFormData() {
        return "home";
    }

    // process form using Model
    @RequestMapping("/processFormModel")
    public String testModelData(HttpServletRequest request, Model model) {

        String param = request.getParameter("f2");
        model.addAttribute("modelAttr", param.toUpperCase());
        return "home";
    }

    // process form data via @RequestParam binding
    @RequestMapping("/processFormModelBinding")
    public String testDataBinding(
            @RequestParam("f3") String request_param_bound,
            Model model) {

        model.addAttribute("modelAttrBinding", request_param_bound.toUpperCase());
        return "home";
    }
}
