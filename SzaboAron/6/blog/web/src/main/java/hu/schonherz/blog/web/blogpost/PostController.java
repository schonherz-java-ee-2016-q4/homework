package hu.schonherz.blog.web.blogpost;

import com.google.gson.Gson;
import hu.schonherz.blog.service.api.blogpost.service.BlogPostService;
import hu.schonherz.blog.service.api.blogpost.vo.BlogPostVO;
import hu.schonherz.blog.web.blogpost.createform.PostCreatorForm;
import hu.schonherz.blog.web.blogpost.model.PostModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by Áron on 2017. 01. 05..
 */
@Controller
@RequestMapping(path = "/")
public class PostController {
    public static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);
    private final Gson gson = new Gson();
    private static final String INDEX_JSP_URL = "index";
    private static final String READ_JSP_URL = "public/blogpost/blogpostreader";

    @Autowired
    private BlogPostService service;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String createNewPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        service.savePost(formToVO(new PostCreatorForm(request)));
        return INDEX_JSP_URL;
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String listPosts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return gson.toJson(service.findAllPost());
    }

    @GetMapping
    public String index() {
        return INDEX_JSP_URL;
    }

    @RequestMapping(path = "/read/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    protected ModelAndView readPost(@PathVariable int id) throws IOException {
        BlogPostVO vo = service.findPostById(id);
        PostModel model = PostModel.builder().title(vo.getPostTitle()).body(vo.getPostBody()).date(vo.getPostPublishTime()).id(vo.getId()).username(vo.getOwner().getUsername()).build();
        return new ModelAndView(READ_JSP_URL, "postModel", model);
    }


    private static BlogPostVO formToVO(PostCreatorForm form) {
        BlogPostVO vo = new BlogPostVO();
        vo.setPostBody(form.getBody());
        vo.setPostTitle(form.getTitle());
        vo.setPostPublishTime(Date.valueOf(LocalDate.now()));
        vo.setOwner(form.getOwner());
        return vo;
    }
}
