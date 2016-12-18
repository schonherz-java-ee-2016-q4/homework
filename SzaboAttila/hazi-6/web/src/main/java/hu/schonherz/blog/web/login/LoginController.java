package hu.schonherz.blog.web.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hu.schonherz.blog.service.UserServiceImpl;
import hu.schonherz.blog.service.api.service.UserService;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.vo.User;

@Controller
public class LoginController {
    private static final String LOGIN_JSP_URL = "public/login.jsp";
	private static final String SECURED_JSP_URL = "secured/secured.jsp";

	@RequestMapping(path="/Login", method=RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LoginForm loginForm = new LoginForm(request);

		String username = loginForm.getUsername();
		UserService userService = new UserServiceImpl();
		User user = null;
		
		try {
			user = userService.findUserByUsername(username);
		} catch (UserNotFoundException e) {
			request.setAttribute("error", "Hibás felhasználónév vagy jelszó!");
			request.getRequestDispatcher(LOGIN_JSP_URL).forward(request, response);
			return;
		}

		if (user != null) {
			String password = loginForm.getPassword();
			if (user.getLogin().getPassword().equals(password)) {
				request.getSession().setAttribute("user", user);
				response.sendRedirect(SECURED_JSP_URL);

			} else {
				request.setAttribute("error", "Hibás felhasználónév vagy jelszó!");
				request.getRequestDispatcher(LOGIN_JSP_URL).forward(request, response);
			}
		}

	}
}
