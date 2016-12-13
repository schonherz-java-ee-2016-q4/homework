package hu.sconherz.blog.web.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import hu.schonherz.blog.service.BlogServiceImpl;
import hu.schonherz.blog.service.api.blog.vo.BlogPost;
import hu.schonherz.blog.service.api.service.BlogService;

/**
 * Servlet implementation class ReadPost
 */
@WebServlet("/ReadPost")
public class ReadPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    BlogService blogService = new BlogServiceImpl();
	    BlogPost bp = blogService.getBlogPostById(Integer.parseInt(request.getParameter("id")));
	    
        Gson gson = new Gson();
        String resultJson = gson.toJson(bp);
        
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        
        response.getWriter().write(resultJson);
	}


}
