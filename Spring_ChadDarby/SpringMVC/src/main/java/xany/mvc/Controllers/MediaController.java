package xany.mvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("media")
public class MediaController {

    @RequestMapping("/login")
    public String showLogin() {
        return "med_login";
    }

    @RequestMapping("m_auth")
    public String auth_med() {
        System.out.println("stub authentication for media portal");
        return "home_media";
    }
}