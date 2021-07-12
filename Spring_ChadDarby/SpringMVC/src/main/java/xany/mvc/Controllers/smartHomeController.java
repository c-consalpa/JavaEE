package xany.mvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("smartHome")
public class smartHomeController {

    @RequestMapping("/login")
    public String login() {
        return "sh_login";
    }

    @RequestMapping("/auth")
    public String authenticate_stub(HttpServletRequest request, Model m) {
        String u_name = request.getParameter("usr_nm");
        if (u_name.equals("123")) {

            return "home_sh";
        } else {
            m.addAttribute("message","Invalid user name : " + u_name);
            return "error";
        }
    }
}
