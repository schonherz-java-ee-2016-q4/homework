package hu.sconherz.blog.web.post;

import com.google.gson.Gson;
import hu.schonherz.blog.service.api.user.exception.PostNotFoundException;
import hu.schonherz.blog.service.api.user.service.PostResult;
import hu.schonherz.blog.service.api.user.service.PostService;
import hu.schonherz.blog.service.api.user.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Geri on 2016. 12. 31..
 */
@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String printPosts() {
        PostResult postResult = new PostResult();
        Gson gson = new Gson();
        return gson.toJson(postResult);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String printPostById(@PathVariable int id) {
        Gson gson = new Gson();
        try {
            return gson.toJson(postService.findById(id));
        } catch (PostNotFoundException e) {
            return "Error! There's no post with this ID!";
        }
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public String add(HttpServletRequest req) {
        PostForm postForm = new PostForm(req);
        PostVO postVO = toVO(postForm);
        postService.add(postVO);
        return "";

    }

    private static PostVO toVO(PostForm postForm) {
        PostVO postVO = new PostVO();
        postVO.setTitle(postForm.getTitle());
        postVO.setContent(postForm.getContent());
        postVO.setPublished(postForm.getPublished());
        postVO.setAuthorID(postForm.getAuthorID());
        return postVO;
    }
}
