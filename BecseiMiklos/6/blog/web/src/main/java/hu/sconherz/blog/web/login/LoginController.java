package hu.sconherz.blog.web.login;

import com.sun.deploy.net.HttpResponse;
import hu.schonherz.blog.service.UserService;
import hu.schonherz.blog.service.api.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/login")
public class LoginController {

    private static final String LOGIN_JSP_URL = "public/login";
    private static final String SECURED_JSP_URL = "secured/secured";

    @Autowired
    UserService userService;

    @RequestMapping(path = "/")
    private String Login(HttpServletRequest request, HttpResponse response) throws ServletException, IOException {

        LoginForm loginForm = new LoginForm(request);

        String username = loginForm.getUsername();

        UserDTO user = null;

        try {
            user = userService.findByUserName(username);

        } catch (UserNotFoundException e) {
            request.setAttribute("error", "Hibás felhasználónév!");
            return LOGIN_JSP_URL;
        }

        if ( user != null ) {
            String password = loginForm.getPassword();

            if (user.getPassword().equals(password)) {
                request.getSession().setAttribute("user", user);
                return SECURED_JSP_URL;
            } else {
                request.setAttribute("error", "Hibás jelszó!");
                return LOGIN_JSP_URL;
            }
        }

        return LOGIN_JSP_URL;
    }

}