package hu.schonherz.blog.web.post;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.blog.service.PostService;
import hu.schonherz.blog.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vo.PostVO;
@Controller
@RequestMapping("/Post")
public class PostController {

	private PostVO vo = new PostVO();
	@Autowired
	private PostService postService;
      
	@RequestMapping(path="/new", method = RequestMethod.POST)
	public String createPost(HttpServletRequest request) throws IOException {
	    request.setCharacterEncoding("UTF-8");

	    PostForm postForm = new PostForm(request);
	    vo.setName(postForm.getName());
	    vo.setTitle(postForm.getTitle());
	    vo.setTextArea(postForm.getTextArea());

	    postService.save(vo);
	    return "index";
	}

}
