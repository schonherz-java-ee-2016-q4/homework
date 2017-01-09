package hu.sconherz.blog.web.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import hu.schonherz.blog.service.PostService;
import hu.schonherz.blog.service.PostServiceImpl;
import hu.schonherz.blog.service.api.user.dao.PostDAO;
import hu.schonherz.blog.service.api.user.dto.PostDTO;
import hu.schonherz.blog.service.api.user.dto.PostResults;
import vo.PostVO;


@WebServlet("/BlogServlet")
public class BlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public BlogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PostService postService = new PostServiceImpl();
        List<PostDTO> posts = (List<PostDTO>) postService.findAll();
        Gson gson = new Gson();
        PostResults result = new PostResults();
        result.setResults(posts);
        String resultJson = gson.toJson(result);
      
        
        response.getWriter().write(resultJson);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
