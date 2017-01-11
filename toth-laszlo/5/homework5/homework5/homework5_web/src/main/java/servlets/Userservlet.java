package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import homework5_service.services.UserService;
import homework5_service.vo.UserVO;

/**
 * Servlet implementation class Userservlet
 */
public class Userservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Userservlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")==null){
		    response.sendRedirect("index.jsp");
		}
		UserService service = new UserService();
		Collection<UserVO> users = new ArrayList<>();
		users= service.findAll();
		Gson gson = new Gson();
		String results=gson.toJson(users);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().write(results);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
