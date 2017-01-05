package hu.schonherz.java.training.kovtamas.web.controller;

import hu.schonherz.java.training.kovtamas.serviceapi.user.exception.UserNotFoundException;
import hu.schonherz.java.training.kovtamas.serviceapi.user.service.UserService;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.UserVo;
import hu.schonherz.java.training.kovtamas.web.pageinfo.PageNames;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    public LoginController() {
    }

    @RequestMapping(method = RequestMethod.POST)
    protected String login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("psw");

        try {
            UserVo user = userService.findUserByName(username);
            if (!user.getLogin().getPassword().equals(password)) {
                return PageNames.LOGIN_PAGE;
            }
            req.getSession().setAttribute("user", user);
            log.debug("login successful for user: {}", username);
            return PageNames.SECURE_PAGE;
        } catch (UserNotFoundException unfe) {
            log.info("unsuccessful login try with username: {}", username);
            return PageNames.LOGIN_PAGE;
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    protected String getMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return PageNames.LOGIN_PAGE;
    }

}
