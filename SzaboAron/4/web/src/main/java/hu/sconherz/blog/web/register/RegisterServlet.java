package hu.sconherz.blog.web.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.blog.service.UserServiceImpl;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.Name;
import hu.schonherz.blog.service.api.user.vo.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String LOGIN_JSP_URL = "public/login.jsp";
    private static final String REGISTER_JSP_URL = "public/register.jsp";
    private static final String INDEX_JSP_URL = "index.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher(LOGIN_JSP_URL).forward(request, response);
    }
}
