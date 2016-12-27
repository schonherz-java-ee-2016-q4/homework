package hu.schonherz.java.training.kovtamas.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import hu.schonherz.java.training.kovtamas.service.UserServiceImpl;
import hu.schonherz.java.training.kovtamas.serviceapi.user.service.UserService;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.UserContainer;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.UserVo;
import java.util.Collection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/web/UserServlet")
public class UserController {

    public UserController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    protected void getAllUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        Collection<UserVo> users = userService.findAllUser();
        UserContainer container = new UserContainer(users);

        Gson gson = new Gson();
        String resultJson = gson.toJson(container);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        response.getWriter().write(resultJson);

    }

//    @RequestMapping(method = RequestMethod.POST)
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        getAllUsers(request, response);
//    }
}
