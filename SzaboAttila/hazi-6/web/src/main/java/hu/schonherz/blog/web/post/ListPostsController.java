package hu.schonherz.blog.web.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import hu.schonherz.blog.service.api.service.BlogService;

@Controller
public class ListPostsController {

    @Autowired
    private BlogService blogService;
    
    @RequestMapping(path="/ListPosts", method= RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String getPosts() {
        return new Gson().toJson(blogService.getAllBlogPostHeader());
    }
}
