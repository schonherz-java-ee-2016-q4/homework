package hu.schonherz.blog.web.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import hu.schonherz.blog.service.api.blog.vo.BlogPost;
import hu.schonherz.blog.service.api.service.BlogService;

@Controller
public class ListPostsController {

    @Autowired
    private BlogService blogService;
    
    @RequestMapping(path="/ListPosts", method= RequestMethod.GET)
    public void getPosts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<BlogPost> bp = blogService.getAllBlogPostHeader();

        Gson gson = new Gson();
        String resultJson = gson.toJson(bp);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        response.getWriter().write(resultJson);
    }
}
