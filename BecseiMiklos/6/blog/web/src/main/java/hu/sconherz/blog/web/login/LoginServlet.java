package hu.sconherz.blog.web.login;

import hu.schonherz.blog.service.api.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String LOGIN_JSP_URL = "public/login.jsp";
	private static final String SECURED_JSP_URL = "secured/secured.jsp";


	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginForm loginForm = new LoginForm(request);

		String username = loginForm.getUsername();
		UserService userService = new UserServiceImpl();
		UserDTO user = null;
		try {

			user = userService.findUserByName(username);

		} catch (UserNotFoundException e) {
			request.setAttribute("error", "Hibás felhasználónév vagy jelszó!");
			request.getRequestDispatcher(LOGIN_JSP_URL).forward(request, response);
			return;
		}

		if (user != null) {
			String password = loginForm.getPassword();
			if (user.getPassword().equals(password)) {
				request.getSession().setAttribute("user", user);
				response.sendRedirect(SECURED_JSP_URL);

			} else {
				request.setAttribute("error", "Hibás felhasználónév vagy jelszó!");
				request.getRequestDispatcher(LOGIN_JSP_URL).forward(request, response);
			}
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher(LOGIN_JSP_URL).forward(request, response);
	}
}
