package hu.schonherz.blog.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.schonherz.blog.data.blog.dao.PostDao;
import hu.schonherz.blog.data.blog.dao.PostTagDao;
import hu.schonherz.blog.data.blog.dto.PostDto;
import hu.schonherz.blog.data.blog.dto.PostTagDto;
import hu.schonherz.blog.data.user.dao.LoginDao;
import hu.schonherz.blog.service.api.blog.vo.BlogPost;
import hu.schonherz.blog.service.api.service.BlogService;
import hu.schonherz.blog.service.api.service.UserService;
import hu.schonherz.blog.service.api.user.vo.UserVo;
import hu.schonherz.blog.service.blog.convert.BlogPostToDto;
import hu.schonherz.blog.service.blog.convert.DtoToBlogPost;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private UserService userService;
    
    @Autowired
    private PostTagDao postTagDao;
    @Autowired
    private PostDao postDao;
    @Autowired
    private LoginDao loginDao;
    
    @Override
    public List<BlogPost> getAllBlogPostHeader() {
        List<BlogPost> t = new ArrayList<>();
        
        List<PostDto> headers = (List<PostDto>) postDao.findAllHeaders();
        
        for (PostDto postDto : headers) {
            List<PostTagDto> postTagsDto = postTagDao.findByPostId(postDto.getId());
            UserVo author = userService.findByUserId(postDto.getUser_id());
            
            t.add(new DtoToBlogPost(postDto, author, postTagsDto).getBlogPost());
        }
        return t;
    }
    
    @Override
    public BlogPost getBlogPostById(int id) {
        PostDto postDto = postDao.findByPostId(id);
        List<PostTagDto> postTagsDto = postTagDao.findByPostId(id);
        UserVo poster = userService.findByUserId(postDto.getUser_id());
        
        return new DtoToBlogPost(postDto, poster, postTagsDto).getBlogPost();
    }
    
    @Override
    public int addNewBlogPost(BlogPost blogPost) {
        BlogPostToDto conv;
        try {
            conv = new BlogPostToDto(blogPost, loginDao.findByUserName(blogPost.getAuthor().getLogin().getUsername()).getUser_id());
            return postDao.save(conv.getPostDto(), conv.getPostTagsDto());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
}
