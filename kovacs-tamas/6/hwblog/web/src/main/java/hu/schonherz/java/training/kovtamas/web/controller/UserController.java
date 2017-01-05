package hu.schonherz.java.training.kovtamas.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.java.training.kovtamas.serviceapi.user.service.UserService;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.UserContainer;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.UserVo;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    protected UserContainer getAllUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Collection<UserVo> users = userService.findAllUser();
        UserContainer container = new UserContainer(users);

        return container;
    }

}
