package hu.schonherz.blog.web.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.blog.service.UserService;
import hu.schonherz.blog.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vo.UserVO;

@Controller
@RequestMapping("/Register")
public class RegisterController {
    @Autowired
	private UserService userService;
    private UserVO vo = new UserVO();

    @RequestMapping("/new")
    protected String Register(HttpServletRequest request) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	   
	    RegisterForm register = new RegisterForm(request);
		
		vo.setFirstName(register.getFirstName());
		vo.setLastName(register.getLastName());
		vo.setUsername(register.getUsername());
		vo.setPassword(register.getPassword());
		vo.setEmail(register.getEmail());
		vo.setGender(register.getGender());
		vo.setDate_of_birth(register.getDate_of_birth());
		vo.setLocation(register.getLocation());
		vo.setPhone(register.getPhone());
		
		userService.save(vo);

		return "public/login";
	}

}
