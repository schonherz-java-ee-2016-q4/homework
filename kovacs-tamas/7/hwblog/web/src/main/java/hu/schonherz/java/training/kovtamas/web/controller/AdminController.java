package hu.schonherz.java.training.kovtamas.web.controller;

import hu.schonherz.java.training.kovtamas.serviceapi.user.service.UserService;
import hu.schonherz.java.training.kovtamas.web.pageinfo.PageNames;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        LOG.debug(req.getParameter("username"));
        LOG.debug(req.getParameter("action"));

        return PageNames.ADMIN_PAGE;
    }

}
