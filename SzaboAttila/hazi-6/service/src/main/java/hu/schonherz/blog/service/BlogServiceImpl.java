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
import hu.schonherz.blog.service.api.blog.vo.BlogPost;
import hu.schonherz.blog.service.api.service.BlogService;
import hu.schonherz.blog.service.api.user.vo.User;
import hu.schonherz.blog.service.blog.convert.BlogPostToDto;
import hu.schonherz.blog.service.blog.convert.DtoToBlogPost;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private PostDao postHeaderDao;
    @Autowired
    private PostTagDao postTagDao;
    
    public BlogServiceImpl() {
    }
    
    @Override
    public List<BlogPost> getAllBlogPostHeader() {
        List<BlogPost> t = new ArrayList<>();
        
        List<PostDto> headers = (List<PostDto>) new PostDao().findAllHeaders();
        
        for (PostDto headerDTO : headers) {
            List<PostTagDto> postTagsDTO = new PostTagDao().findByPostId(headerDTO.getId());
            
            UserServiceImpl us = new UserServiceImpl();
            User author = us.findByUserId(headerDTO.getUser_id());
            
            t.add(new DtoToBlogPost(headerDTO, author, postTagsDTO).getBlogPost());
        }
        return t;
    }
    
    @Override
    public BlogPost getBlogPostById(int id) {
        PostDto headerDTO = postHeaderDao.findByPostId(id);
        List<PostTagDto> postTagsDTO = postTagDao.findByPostId(id);
        
        UserServiceImpl us = new UserServiceImpl();
        User poster = us.findByUserId(headerDTO.getUser_id());
        
        return new DtoToBlogPost(headerDTO, poster, postTagsDTO).getBlogPost();
    }
    
    @Override
    public int addNewBlogPost(BlogPost blogPost) {
        BlogPostToDto conv;
        try {
            conv = new BlogPostToDto(blogPost);
            return new PostDao().save(conv.getHeaderDTO(), conv.getPostTagsDTO());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
}
