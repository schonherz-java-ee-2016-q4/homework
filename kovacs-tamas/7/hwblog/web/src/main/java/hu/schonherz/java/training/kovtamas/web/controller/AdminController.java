package hu.schonherz.java.training.kovtamas.web.controller;

import hu.schonherz.java.training.kovtamas.serviceapi.user.exception.UserNotFoundException;
import hu.schonherz.java.training.kovtamas.serviceapi.user.service.UserService;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.UserVo;
import hu.schonherz.java.training.kovtamas.web.pageinfo.PageNames;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private UserService userService;

    @GetMapping
    public String goToAdminPage() {
        return PageNames.ADMIN_PAGE;
    }

    @PostMapping
    public String grantOrRemoveRole(HttpServletRequest req) {
        String username = req.getParameter("username");
        String role = req.getParameter("role").toUpperCase();
        final String successAttr = "processMsg";

        try {
            UserVo user = userService.findUserByName(username);
            if (!role.equals(user.getRole())) {
                user.setRole(role);
                userService.updateRole(user);
                req.setAttribute(successAttr, "Success!");
            } else {
                req.setAttribute(successAttr, "The user " + username + " has already been set to " + role + " role!");
            }
        } catch (Exception ex) {
            LOG.warn("Cannot find user with username: {}", username);
            req.setAttribute(successAttr, "Failed to set role!");
        }

        return PageNames.ADMIN_PAGE;
    }

}
