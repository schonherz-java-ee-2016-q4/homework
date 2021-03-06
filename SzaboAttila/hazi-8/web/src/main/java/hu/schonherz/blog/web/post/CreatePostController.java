package hu.schonherz.blog.web.post;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.schonherz.blog.service.api.blog.vo.BlogPost;
import hu.schonherz.blog.service.api.service.BlogService;
import hu.schonherz.blog.service.api.service.UserService;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.vo.UserVo;

@Controller
public class CreatePostController {
    private static final String CREATED_POST_JSP_URL = "secured/post.jsp?id=";

    @Autowired
    private UserService userService;
    @Autowired
    private BlogService blogService;
    
    @RequestMapping(path="/CreatePost", method = RequestMethod.POST)
	public ModelAndView createPost(HttpServletRequest request) throws IOException, UserNotFoundException {
	    request.setCharacterEncoding("UTF-8");
	    UserVo user = userService.findUserByUsername(request.getUserPrincipal().getName());
	    CreatePostForm cpf = new CreatePostForm(request, user);
	    int created_id = blogService.addNewBlogPost(createBlogPost(cpf));
	    
	    return new ModelAndView("redirect:/" + CREATED_POST_JSP_URL + created_id);
	}

	private BlogPost createBlogPost(CreatePostForm cpf) {
	    BlogPost bp = new BlogPost();
	    
	    bp.setTitle(cpf.getTitle());
	    bp.setContent(cpf.getContent());
	    bp.setPosted(new SimpleDateFormat("yyyy-MM-dd kk:mm").format(new Date()));
	    bp.setTags(cpf.getTags());
	    bp.setAuthor(cpf.getAuthor());
	    
	    return bp;
	}
	
}
