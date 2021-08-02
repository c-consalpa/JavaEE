package xany.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Test {

    @RequestMapping("test")
    public String testMethod(@RequestParam("foo") String param, Model model) {

        model.addAttribute("mAttrKey", param);
        return "test";
    }
}
