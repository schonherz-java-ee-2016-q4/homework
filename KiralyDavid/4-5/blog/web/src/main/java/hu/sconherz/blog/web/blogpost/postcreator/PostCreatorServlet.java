package hu.sconherz.blog.web.blogpost.postcreator;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import hu.schonherz.blog.service.api.blogpost.service.BlogPostService;
import hu.schonherz.blog.service.api.blogpost.vo.BlogPostVO;
import hu.schonherz.blog.service.api.user.vo.UserVO;
import hu.schonherz.blog.service.blogpostservice.BlogPostServiceImpl;

@WebServlet("/PostCreator")
public class PostCreatorServlet extends HttpServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(PostCreatorServlet.class);
    private static final long serialVersionUID = 8690967238623430489L;
    private final BlogPostService service = new BlogPostServiceImpl();
    private final Gson gson = new Gson();
    private static final String INDEX_JSP_URL = "index.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info(((UserVO) request.getSession().getAttribute("user")).getId() + "");
        request.setCharacterEncoding("UTF-8");
        LOGGER.info(request.getParameter("title"));
        LOGGER.info(request.getParameter("body"));
        service.savePost(formToVO(new PostCreatorForm(request)));
        response.sendRedirect(INDEX_JSP_URL);
    }

    private static BlogPostVO formToVO(PostCreatorForm form) {
        BlogPostVO vo = new BlogPostVO();
        vo.setPostBody(form.getBody());
        vo.setPostTitle(form.getTitle());
        vo.setPostPublishTime(Date.valueOf(LocalDate.now()));
        vo.setOwner(form.getOwner());
        System.out.println(vo.getOwner());
        return vo;
    }

}
