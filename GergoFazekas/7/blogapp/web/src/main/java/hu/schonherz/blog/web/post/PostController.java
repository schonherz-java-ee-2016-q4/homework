package hu.schonherz.blog.web.post;

import hu.schonherz.blog.service.post.exception.PostNotFoundException;
import hu.schonherz.blog.service.post.service.PostService;
import hu.schonherz.blog.service.post.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Geri on 2017. 01. 04..
 */
@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public ModelAndView printPosts() {
        List<PostVO> posts = postService.findAll();
        return new ModelAndView("/public/posts", "posts", posts);
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView printPost(@PathVariable int id) throws PostNotFoundException {
        PostVO postVO;
        postVO = postService.findById(id);
        return new ModelAndView("index", "post", postVO);

    }

    @RequestMapping(path = "/posts/new", method = RequestMethod.POST)
    public String savePost(HttpServletRequest req) {
        PostForm postForm = new PostForm(req);
        postService.add(toVO(postForm));
        return "redirect:/posts";
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
