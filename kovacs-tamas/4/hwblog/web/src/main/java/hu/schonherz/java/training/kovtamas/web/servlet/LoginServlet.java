package hu.schonherz.java.training.kovtamas.web.servlet;

import hu.schonherz.java.training.kovtamas.service.UserServiceImpl;
import hu.schonherz.java.training.kovtamas.serviceapi.user.exception.UserNotFoundException;
import hu.schonherz.java.training.kovtamas.serviceapi.user.service.UserService;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private final UserService userService;
    private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);

    public LoginServlet() {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("usrname");
        String password = req.getParameter("psw");

        try {
            User user = userService.findUserByName(username);
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToLoginPage(req, resp);
    }

    private void forwardToLoginPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("invalidLogin", "invalidLogin");
        req.getRequestDispatcher("resources/pages/public/login.jsp").forward(req, resp);
    }

}
