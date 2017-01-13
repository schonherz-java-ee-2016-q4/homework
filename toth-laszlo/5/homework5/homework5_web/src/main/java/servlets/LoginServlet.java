package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework5_service.services.UserService;
import homework5_service.vo.UserVO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service = new UserService();
	
    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String user;
		String pass;
		UserVO uservo = new UserVO();
		user = request.getParameter("user");
		pass = request.getParameter("pass");
		if((uservo=service.findByUserName(user))!=null){
		    if(uservo.getPassword().equals(pass)){
		        request.getSession().setAttribute("user", user);
		        response.sendRedirect("secured/users.jsp");
		    }
		    else out.write(":(");
		}
		else out.write(":(");
	    
		
	}

}
