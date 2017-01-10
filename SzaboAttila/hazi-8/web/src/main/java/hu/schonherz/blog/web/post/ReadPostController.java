package hu.schonherz.blog.web.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import hu.schonherz.blog.service.api.service.BlogService;

@Controller
public class ReadPostController {

    @Autowired
    private BlogService blogService;
    
    @RequestMapping(path="/ReadPost/{id}", method= RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String getBlog(@PathVariable int id) {
        return new Gson().toJson(blogService.getBlogPostById(id));
	}
}
