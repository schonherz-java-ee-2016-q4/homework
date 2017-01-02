package hu.sconherz.blog.web.user;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import hu.schonherz.blog.service.api.user.service.UserService;

@Controller
public class UserController {

    private final Gson gson = new Gson();
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/UserController", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    protected String listUsers() throws ServletException, IOException {
        return gson.toJson(userService.findAllUser());

    }

    // private List<UserVO> scanUserList(HttpServletRequest request,
    // List<UserVO> userList) {
    // if (!"".equals(request.getParameter("email"))) {
    // userList = userList.stream().filter(user ->
    // user.getEmail().equals(request.getParameter("email")))
    // .collect(Collectors.toList());
    // }
    // if (!"".equals(request.getParameter("city"))) {
    // userList = userList.stream().filter(user ->
    // user.getCity().equals(request.getParameter("city")))
    // .collect(Collectors.toList());
    // }
    // return userList;
    // }
}
