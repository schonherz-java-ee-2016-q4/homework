package hu.sconherz.blog.web.login;

import hu.schonherz.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Login")
public class LoginController {

    private static final String LOGIN_JSP_URL = "public/login";
    private static final String SECURED_JSP_URL = "secured/secured";

    @Autowired
    UserService userService;

}
