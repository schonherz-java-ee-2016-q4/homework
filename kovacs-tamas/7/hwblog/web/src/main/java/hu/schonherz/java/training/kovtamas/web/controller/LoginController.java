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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    public LoginController() {
    }

    @PostMapping
    protected String login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("psw");
        String unsuccessfulMsgTemplate = "unsuccessful login try with username: {}";

        try {
            UserVo user = userService.findUserByName(username);
            if (!user.getLogin().getPassword().equals(password)) {
                log.warn(unsuccessfulMsgTemplate, username);
                req.setAttribute("invalidLogin", "invalidLogin");
                return PageNames.LOGIN_PAGE;
            }
            req.getSession().setAttribute("user", user);
            log.debug("The user {} has logged in", username);
            return PageNames.SECURE_PAGE;
        } catch (UserNotFoundException unfe) {
            log.warn(unsuccessfulMsgTemplate, username);
            req.setAttribute("invalidLogin", "invalidLogin");
            return PageNames.LOGIN_PAGE;
        }
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
