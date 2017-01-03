package hu.sconherz.blog.web.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.UserVO;

@Controller
public class LoginController {
    
    private static final String LOGIN_JSP_URL = "public/login.jsp";
    private static final String INDEX_JSP_URL = "index.jsp";
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(path = "/Login", method = RequestMethod.POST)
    public String login(HttpServletRequest req) {
        LoginForm loginForm = new LoginForm(req);
        String username = loginForm.getUsername();
        UserVO userVO = null;
        try {
            userVO = userService.findByUsername(username);
            
        } catch (UserNotFoundException e) {
            return LOGIN_JSP_URL;
        }
        if (userVO != null) {
            String password = loginForm.getPassword();
            if (userVO.getPassword().equals(password)) {
                req.getSession().setAttribute("user", userVO);
                return INDEX_JSP_URL;
            } 
        }
        return LOGIN_JSP_URL; 
    }

}
