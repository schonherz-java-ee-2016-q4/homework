package hu.schonherz.java.training.kovtamas.web.controller;

import hu.schonherz.java.training.kovtamas.web.pageinfo.PageNames;
import java.io.IOException;
import javax.servlet.ServletException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    public LoginController() {
    }

    @PostMapping
    public String login() {
        return PageNames.USER_PAGE;
    }

    @GetMapping
    public String getMethod() throws ServletException, IOException {
        return PageNames.LOGIN_PAGE;
    }

    @GetMapping(value = "/error")
    public String loginError(ModelMap model) {
        model.addAttribute("error", "true");
        return PageNames.LOGIN_PAGE;
    }
}
