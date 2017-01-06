package hu.sconherz.blog.web.blogpost.postgetter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import hu.schonherz.blog.service.api.blogpost.service.BlogPostService;

@Controller
public class PostReaderController {
    public static final Logger LOGGER = LoggerFactory.getLogger(PostReaderController.class);
    private static final Gson gson = new Gson();
    @Autowired
    private BlogPostService service;

    @RequestMapping(path = "/PostReader/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    protected String readPost(@PathVariable int id) throws IOException {
        return gson.toJson(service.findPostById(id));
    }

}
