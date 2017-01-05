package hu.schonherz.java.training.kovtamas.web.controller;

import hu.schonherz.java.training.kovtamas.serviceapi.user.exception.UserNotFoundException;
import hu.schonherz.java.training.kovtamas.serviceapi.user.service.UserService;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.UserVo;
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

//    @RequestMapping(path = "/login", method = RequestMethod.POST)
    @RequestMapping(method = RequestMethod.POST)
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("psw");

        try {
            UserVo user = userService.findUserByName(username);
            if (!user.getLogin().getPassword().equals(password)) {
                forwardToLoginPage(req, resp);
            }
            req.getSession().setAttribute("user", user);
            log.debug("login successful for user: {}", username);
            resp.sendRedirect("resources/pages/secure/securePage.jsp");
        } catch (UserNotFoundException unfe) {
            log.info("unsuccessful login try with username: {}", username);
            forwardToLoginPage(req, resp);
        }
    }

//    @RequestMapping(path = "/login", method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET)
    protected void getMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToLoginPage(req, resp);
    }

    private void forwardToLoginPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("invalidLogin", "invalidLogin");
        req.getRequestDispatcher("resources/pages/public/login.jsp").forward(req, resp);
    }

}
