package hu.schonherz.blog.web.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.blog.service.UserService;
import hu.schonherz.blog.service.UserServiceImpl;
import hu.schonherz.blog.service.api.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class Login
 */
@Controller
@RequestMapping("/Login")
public class LoginController {


	private static final String LOGIN_JSP_URL = "public/login";
	private static final String SECURED_JSP_URL = "secured/secured";
	@Autowired
	UserService userService;

	@RequestMapping(path="/")
	protected String Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginForm loginForm = new LoginForm(request);

		String username = loginForm.getUsername();

		UserDTO user = null;
		try {

			user = userService.findByUserName(username);

		} catch (UserNotFoundException e) {
			request.setAttribute("error", "Hibás felhasználónév vagy jelszó!");
			//request.getRequestDispatcher(LOGIN_JSP_URL).forward(request, response);
			return LOGIN_JSP_URL;
		}

		if (user != null) {
			String password = loginForm.getPassword();
			if (user.getPassword().equals(password)) {
				request.getSession().setAttribute("user", user);
				//response.sendRedirect(SECURED_JSP_URL);
				return SECURED_JSP_URL;
			} else {
				request.setAttribute("error", "Hibás felhasználónév vagy jelszó!");
				//request.getRequestDispatcher(LOGIN_JSP_URL).forward(request, response);
				return LOGIN_JSP_URL;
			}
		}
			return LOGIN_JSP_URL;
	}


}
