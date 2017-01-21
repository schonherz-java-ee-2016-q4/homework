package hu.schonherz.java.training.kovtamas.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @GetMapping
    protected String getMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // If somebody is logged in
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(req, resp, auth);
            req.getSession().invalidate();  // Kill the session so that it will sure to be clean next time
        }

        return "redirect:/login";
    }

}
