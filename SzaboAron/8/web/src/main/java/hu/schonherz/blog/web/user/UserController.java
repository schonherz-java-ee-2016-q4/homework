package hu.schonherz.blog.web.user;

import com.google.gson.Gson;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    private final Gson gson = new Gson();
    private static final String ADMIN_JSP_URL = "admin/admin";

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(path = "/listusers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    protected String listUsers() throws ServletException, IOException {
        return gson.toJson(userService.findAllUser());
    }

    @PostMapping(path = "/admin/switchUserStatus")
    public String switchUserStatus(@RequestParam("username") String username) {
        System.out.println(username);
        userService.switchUserStatus(username);
        return ADMIN_JSP_URL;
    }


    private List<UserVO> filterUserList(HttpServletRequest request,
                                        List<UserVO> userList) {
        if (!"".equals(request.getParameter("email"))) {
            userList = userList.stream().filter(user ->
                    user.getEmail().equals(request.getParameter("email")))
                    .collect(Collectors.toList());
        }
        if (!"".equals(request.getParameter("city"))) {
            userList = userList.stream().filter(user ->
                    user.getCity().equals(request.getParameter("city")))
                    .collect(Collectors.toList());
        }
        return userList;
    }
}
