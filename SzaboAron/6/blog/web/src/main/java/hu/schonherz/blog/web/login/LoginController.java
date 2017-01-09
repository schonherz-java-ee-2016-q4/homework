package hu.schonherz.blog.web.login;

import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/login")
public class LoginController {
    Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    private static final String LOGIN_JSP_URL = "public/login/login";
    private static final String INDEX_JSP_URL = "index";

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String loginPage() {
        return LOGIN_JSP_URL;
    }

    @RequestMapping(path = "/loginuser", method = RequestMethod.POST)
    public String loginUser(HttpServletRequest request) throws IOException {
        LoginForm loginForm = new LoginForm(request);
        String username = loginForm.getUsername();
        UserVO user = null;
        try {
            user = userService.findUserByName(username);
        } catch (UserNotFoundException e) {
            return LOGIN_JSP_URL;
        }
        if (user != null)

        {
            String password = loginForm.getPassword();
            if (user.getPassword().equals(password)) {
                request.getSession().setAttribute("user", user);
                return INDEX_JSP_URL;
            } else {
                return LOGIN_JSP_URL;
            }
        }
        return INDEX_JSP_URL;
    }

}
