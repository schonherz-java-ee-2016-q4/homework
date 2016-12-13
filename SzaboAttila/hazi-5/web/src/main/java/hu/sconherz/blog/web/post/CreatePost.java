package hu.sconherz.blog.web.post;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.blog.service.BlogServiceImpl;
import hu.schonherz.blog.service.api.blog.vo.BlogPost;
import hu.schonherz.blog.service.api.service.BlogService;

/**
 * Servlet implementation class CreatePost
 */
@WebServlet("/CreatePost")
public class CreatePost extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String CREATED_POST_JSP_URL = "secured/post.jsp?id=";

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    CreatePostForm cpf = new CreatePostForm(request);
	    BlogPost blogPost = createBlogPost(cpf);
	    
	    BlogService blogService = new BlogServiceImpl();
	    int created_id = blogService.addNewBlogPost(blogPost);
	    
	    response.sendRedirect(CREATED_POST_JSP_URL + created_id);
	}

	private BlogPost createBlogPost(CreatePostForm cpf) {
	    BlogPost bp = new BlogPost();
	    
	    bp.setTitle(cpf.getTitle());
	    bp.setText(cpf.getText());
	    bp.setPosted(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " 00:00:00");
	    bp.setTags(cpf.getTags());
	    bp.setPoster(cpf.getUser());
	    
	    return bp;
	}
	
}
