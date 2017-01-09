package hu.schonherz.blog.web.blogpost.postgetter;

import com.google.gson.Gson;
import hu.schonherz.blog.service.api.blogpost.service.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PostListerController {
    public static final Logger LOGGER = LoggerFactory.getLogger(PostListerController.class);
    private static final Gson gson = new Gson();
    @Autowired
    private BlogPostService service;

    @RequestMapping(path = "/postlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String listPosts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return gson.toJson(service.findAllPost());
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
