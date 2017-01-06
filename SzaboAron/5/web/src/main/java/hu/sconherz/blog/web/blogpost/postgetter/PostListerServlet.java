package hu.sconherz.blog.web.blogpost.postgetter;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import hu.schonherz.blog.service.api.blogpost.service.BlogPostService;
import hu.schonherz.blog.service.api.blogpost.vo.BlogPostVO;
import hu.schonherz.blog.service.blogpostservice.BlogPostServiceImpl;

@WebServlet("/PostLister")
public class PostListerServlet extends HttpServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(PostListerServlet.class);
    private static final long serialVersionUID = 8690967238623430489L;
    private final BlogPostService service = new BlogPostServiceImpl();
    private final Gson gson = new Gson();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<BlogPostVO> posts = service.findAllPost();
        String resultJson = gson.toJson(posts);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(resultJson);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
