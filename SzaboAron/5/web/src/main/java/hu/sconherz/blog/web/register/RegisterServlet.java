package hu.sconherz.blog.web.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String LOGIN_JSP_URL = "public/login.jsp";
    private static final String INDEX_JSP_URL = "index.jsp";
    private static final String SUCCESS_JSP_URL = "public/registration/success.jsp";

    public RegisterServlet() {
        super();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Save the user data to the database
        response.sendRedirect(SUCCESS_JSP_URL);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
