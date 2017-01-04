package hu.schonherz.blog.web.post;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vo.PostVO;

@Controller
@RequestMapping("/BlogServlet")
public class BlogController {

    @Autowired
    private PostService postService;

    @RequestMapping(path= "/new")
	protected void createBlog(HttpServletResponse response) throws IOException {
	
	    response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        List<PostDTO> posts = (List<PostDTO>) postService.findAll();
        Gson gson = new Gson();
        PostResults result = new PostResults();
        result.setResults(posts);
        String resultJson = gson.toJson(result);
      
        
        response.getWriter().write(resultJson);

	}




}
