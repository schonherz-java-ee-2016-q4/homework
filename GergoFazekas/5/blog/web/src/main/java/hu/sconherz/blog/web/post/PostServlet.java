package hu.sconherz.blog.web.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.blog.service.PostServiceImpl;
import hu.schonherz.blog.service.api.user.service.PostService;
import hu.schonherz.blog.service.api.user.vo.PostVO;

@WebServlet("/Post")
public class PostServlet extends HttpServlet {

    
    private static final String INDEX_JSP_URL = "index.jsp";
    
    public PostServlet() {
        super();
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostForm postForm = new PostForm(req);
        PostService postService = new PostServiceImpl();
        postService.add(toVO(postForm));
        resp.sendRedirect(INDEX_JSP_URL);
    }
    
    private static PostVO toVO(PostForm postForm) {
        PostVO postVO = new PostVO();
        postVO.setTitle(postForm.getTitle());
        postVO.setContent(postForm.getContent());
        postVO.setPublished(postForm.getPublished());
        postVO.setAuthorID(postForm.getAuthorID());
        return postVO;
    }
}
