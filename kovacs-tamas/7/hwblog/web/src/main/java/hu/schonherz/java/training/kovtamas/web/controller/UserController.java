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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController() {
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public ResponseEntity<UserContainer> getAllUsers() throws ServletException, IOException {
        Collection<UserVo> users = userService.findAllUser();
        UserContainer container = new UserContainer(users);
        ResponseEntity<UserContainer> entities = new ResponseEntity<>(container, HttpStatus.OK);

        return entities;
    }

}
