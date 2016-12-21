package hu.sconherz.blog.web.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.blog.service.UserService;
import hu.schonherz.blog.service.UserServiceImpl;
import hu.schonherz.blog.service.api.user.dto.UserDTO;
import vo.UserVO;


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService = new UserServiceImpl();
    private UserVO vo = new UserVO();
    public RegisterServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		
	}

}
