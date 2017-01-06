package hu.schonherz.blog.web.user;

import com.google.gson.Gson;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    private final Gson gson = new Gson();
    private static final String USER_JSP_URL = "secured/secured";

    @Autowired
    private UserService userService;

    @GetMapping
    public String usersPage() {
        return USER_JSP_URL;
    }

    @ResponseBody
    @RequestMapping(path = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    protected String listUsers() throws ServletException, IOException {
        return gson.toJson(userService.findAllUser());

    }

    private List<UserVO> scanUserList(HttpServletRequest request,
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
