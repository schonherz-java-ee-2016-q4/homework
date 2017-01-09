package hu.sconherz.blog.web.login;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.UserVO;

@Controller
public class LoginController {

    private static final String LOGIN_JSP_URL = "public/login";
    private static final String INDEX_JSP_URL = "index";

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/Login", method = RequestMethod.POST)
    protected String loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LoginForm loginForm = new LoginForm(request);
        String username = loginForm.getUsername();
        UserVO user = null;
        try {
            user = userService.findUserByName(username);
        } catch (UserNotFoundException e) {
            return LOGIN_JSP_URL;
        }
        if (user != null) {
            String password = loginForm.getPassword();
            if (user.getPassword().equals(password)) {
                request.getSession().setAttribute("user", user);
                return INDEX_JSP_URL;
            } else {
                return LOGIN_JSP_URL;
            }
        }
        return null;
    }

}
