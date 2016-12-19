package hu.schonherz.blog.web.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import hu.schonherz.blog.service.api.service.UserService;
import hu.schonherz.blog.service.api.user.vo.User;
import hu.schonherz.blog.service.api.user.vo.UserResult;

@Controller
public class UserController {

    @Autowired
    private UserService userService; 
    
    @RequestMapping(path="/UserServlet", method=RequestMethod.GET)
	public void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> users = userService.findAllUser();
		Gson gson = new Gson();
		UserResult result = new UserResult();
		result.setResults(users);
		String resultJson = gson.toJson(result);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		response.getWriter().write(resultJson);
	}
}
