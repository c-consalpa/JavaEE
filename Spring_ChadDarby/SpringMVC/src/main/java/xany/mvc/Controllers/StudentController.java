package xany.mvc.Controllers;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import xany.mvc.models.Student;

//import javax.validation.Valid;

@Controller
@RequestMapping("students")
public class StudentController {

    @RequestMapping("/showForm")
    public String display(Model m) {
        m.addAttribute("std", new Student());
        return "student_form";
    }
    @RequestMapping("/processForm")
    public String submitForm(@Valid @ModelAttribute("std") Student student, BindingResult br) {
        System.out.println(br);
        if(br.hasErrors()) {
            return "student_form";
        }
        else {
            return "student_confirm";
        }
    }
}
