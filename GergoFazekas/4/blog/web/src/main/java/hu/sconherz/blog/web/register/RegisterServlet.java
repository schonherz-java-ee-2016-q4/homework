package hu.sconherz.blog.web.register;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import hu.schonherz.blog.service.UserServiceImpl;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.User;
import hu.schonherz.blog.service.api.user.vo.UserResult;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private static final String LOGIN_JSP_URL = "public/login.jsp";
	private static final String REGISTER_JSP_URL = "public/register.jsp";
	private static final String REGSUCCESS_JSP_URL = "secured/regsuccess.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.getRequestDispatcher(REGISTER_JSP_URL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RegisterForm registerForm = new RegisterForm(request);
	    User newUser = registerForm.getUser();
	    UserService userService = new UserServiceImpl();
	    List<User> users = userService.findAllUser();
	    users.add(newUser);
	    Gson gson = new Gson();
        UserResult result = new UserResult();
        result.setResults(users);
        String resultJson = gson.toJson(result);
        try (FileWriter fw = new FileWriter(new File("example.txt"), false)) {
            fw.write(resultJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
	    request.getSession().setAttribute("user", newUser);
        response.sendRedirect(REGSUCCESS_JSP_URL);
	}

}
