package hu.schonherz.java.training.kovtamas.web.controller;

import hu.schonherz.java.training.kovtamas.web.pageinfo.PageNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secured")
public class SecuredController {

    @GetMapping
    public String redirectToSecuredPage() {
        return PageNames.SECURE_PAGE;
    }
}
