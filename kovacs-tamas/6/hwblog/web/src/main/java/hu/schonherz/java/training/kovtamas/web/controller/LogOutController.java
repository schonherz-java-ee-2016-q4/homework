package hu.schonherz.java.training.kovtamas.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/logout")
public class LogOutController {

    @RequestMapping(method = RequestMethod.GET)
    protected void getMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        redirectToLoginPage(req, resp);
    }

    @RequestMapping(method = RequestMethod.POST)
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("user");
        redirectToLoginPage(req, resp);
    }

    private void redirectToLoginPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.sendRedirect("resources/pages/public/login.jsp");
    }
}
