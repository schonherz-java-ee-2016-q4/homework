package hu.sconherz.blog.web.post;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hu.schonherz.blog.service.BlogServiceImpl;
import hu.schonherz.blog.service.UserServiceImpl;
import hu.schonherz.blog.service.api.blog.vo.PostBlog;
import hu.schonherz.blog.service.api.service.BlogService;
import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostBlogDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dao.LoginDAO;
import hu.schonherz.blog.service.api.user.service.data.user.dao.UserDAO;
import hu.schonherz.blog.service.api.user.vo.User;

/**
 * Servlet implementation class CreatePost
 */
@WebServlet("/CreatePost")
public class CreatePost extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String CREATED_POST_JSP_URL = "secured/post.jsp?id=";
    String username;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    CreatePostForm cpf = new CreatePostForm(request);
	    PostBlog blogPost = createBlogPost(cpf);
	    
	    BlogService blogService = new BlogServiceImpl();
	    int created_id = blogService.addNewBlogPost(blogPost);
	    
	    response.sendRedirect(CREATED_POST_JSP_URL + created_id);
	}

	private PostBlog createBlogPost(CreatePostForm postform) {
	    PostBlog postblog = new PostBlog();
	    
	    postblog.setHeader(postform.getTitle());
	    postblog.setContent(postform.getText());
	    postblog.setCreated(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " 00:00:00");
	    postblog.setTags(postform.getTags());
	    postblog.setUsername(postform.getUser().getLogin().getUsername());
	    return postblog;
	}
	
}
