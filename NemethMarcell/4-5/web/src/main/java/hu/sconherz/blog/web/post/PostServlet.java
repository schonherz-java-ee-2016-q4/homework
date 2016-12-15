package hu.sconherz.blog.web.post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.blog.service.PostService;
import hu.schonherz.blog.service.PostServiceImpl;
import hu.schonherz.blog.service.api.user.dao.PostDAO;
import hu.schonherz.blog.service.api.user.dto.PostDTO;
import vo.PostVO;

@WebServlet("/Post")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      PostVO vo = new PostVO();
      PostService postService = new PostServiceImpl();
      
    public PostServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    
	    PostForm postForm = new PostForm(request);
	    vo.setName(postForm.getName());
	    vo.setTitle(postForm.getTitle());
	    vo.setTextArea(postForm.getTextArea());
	    
	    postService.save(vo);
	    response.sendRedirect("index.jsp");
	}

}
