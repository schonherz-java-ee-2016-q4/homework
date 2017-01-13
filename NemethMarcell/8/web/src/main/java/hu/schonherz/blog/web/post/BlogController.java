package hu.schonherz.blog.web.post;

import com.google.gson.Gson;
import hu.schonherz.blog.service.PostService;
import hu.schonherz.blog.vo.PostResults;
import hu.schonherz.blog.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/BlogServlet")
public class BlogController {

    @Autowired
    private PostService postService;

    @RequestMapping(path= "/new")
	protected void createBlog(HttpServletResponse response) throws IOException {
	
	    response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        List<PostVO> posts = (List<PostVO>) postService.findAll();
        Gson gson = new Gson();
        PostResults result = new PostResults();
        result.setResults(posts);
        String resultJson = gson.toJson(result);
      
        
        response.getWriter().write(resultJson);

	}




}
