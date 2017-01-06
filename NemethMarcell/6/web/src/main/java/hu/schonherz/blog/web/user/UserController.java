package hu.schonherz.blog.web.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import hu.schonherz.blog.service.UserService;
import hu.schonherz.blog.service.UserServiceImpl;
import hu.schonherz.blog.service.api.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.dto.UserResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class UserServlet
 */
@Controller
@RequestMapping("/UserServlet")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/new")
    public void createUser(HttpServletResponse response)
            throws ServletException, IOException {
       
        
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        List<UserDTO> users = (List<UserDTO>) userService.findAll();
        Gson gson = new Gson();
        UserResults result = new UserResults();
        result.setResults(users);
        String resultJson = gson.toJson(result);
      
        
        response.getWriter().write(resultJson);
        
        
    }


}