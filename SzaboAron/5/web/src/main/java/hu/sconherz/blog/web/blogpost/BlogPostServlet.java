package hu.sconherz.blog.web.blogpost;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import hu.schonherz.blog.service.api.blogpost.service.BlogPostService;
import hu.schonherz.blog.service.api.blogpost.vo.BlogPostVO;
import hu.schonherz.blog.service.blogpostservice.BlogPostServiceImpl;

@WebServlet("/BlogPostServlet")
public class BlogPostServlet extends HttpServlet {
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
        System.out.println(request.getParameter("post"));
        service.savePost(toVO(request));
        response.sendRedirect("index.jsp");
    }

    private static BlogPostVO toVO(HttpServletRequest request) {
        BlogPostVO vo = new BlogPostVO();
        vo.setPostBody(request.getParameter("post"));
        vo.setPostTitle(request.getParameter("title"));
        vo.setPostPublishTime(Date.valueOf(LocalDate.now()));
        System.out.println(request.getAttribute("user"));
        vo.setUserId(100);
        return vo;
    }
}
