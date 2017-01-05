package hu.sconherz.blog.web.blogpost.postgetter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import hu.schonherz.blog.service.api.blogpost.service.BlogPostService;

@Controller
public class PostListerController {
    public static final Logger LOGGER = LoggerFactory.getLogger(PostListerController.class);
    private static final Gson gson = new Gson();
    @Autowired
    private BlogPostService service;

    @RequestMapping(path = "/PostLister", method = RequestMethod.GET)
    protected String listPosts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return gson.toJson(service.findAllPost());
    }
}
