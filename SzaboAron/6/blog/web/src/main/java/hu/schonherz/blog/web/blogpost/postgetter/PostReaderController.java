package hu.schonherz.blog.web.blogpost.postgetter;

import com.google.gson.Gson;
import hu.schonherz.blog.service.api.blogpost.service.BlogPostService;
import hu.schonherz.blog.service.api.blogpost.vo.BlogPostVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class PostReaderController {
    public static final Logger LOGGER = LoggerFactory.getLogger(PostReaderController.class);
    private static final Gson gson = new Gson();
    private static final String READ_JSP_URL = "public/blogpost/blogpostreader";
    @Autowired
    private BlogPostService service;

    @RequestMapping(path = "/postreader/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    protected ModelAndView readPost(@PathVariable int id) throws IOException {
        BlogPostVO vo = service.findPostById(id);
        PostModel model = PostModel.builder().title(vo.getPostTitle()).body(vo.getPostBody()).date(vo.getPostPublishTime()).id(vo.getId()).username(vo.getOwner().getUsername()).build();
        return new ModelAndView(READ_JSP_URL, "postModel", model);
    }

}
