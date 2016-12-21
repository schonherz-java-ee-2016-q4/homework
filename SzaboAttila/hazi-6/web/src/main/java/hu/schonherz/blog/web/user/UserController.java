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
import hu.schonherz.blog.service.api.user.vo.UserVo;
import hu.schonherz.blog.service.api.user.vo.UserResultVo;

@Controller
public class UserController {

    @Autowired
    private UserService userService; 
    
    @RequestMapping(path="/listUsers", method=RequestMethod.GET)
	public void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<UserVo> users = userService.findAllUser();
		Gson gson = new Gson();
		UserResultVo result = new UserResultVo();
		result.setResults(users);
		String resultJson = gson.toJson(result);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		response.getWriter().write(resultJson);
	}
}
