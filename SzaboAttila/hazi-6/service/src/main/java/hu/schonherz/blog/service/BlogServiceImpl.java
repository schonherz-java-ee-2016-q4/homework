package hu.schonherz.blog.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.blog.data.blog.dao.PostHeaderDAO;
import hu.schonherz.blog.data.blog.dao.PostTagDAO;
import hu.schonherz.blog.data.blog.dto.PostHeaderDTO;
import hu.schonherz.blog.data.blog.dto.PostTagDTO;
import hu.schonherz.blog.service.api.blog.vo.BlogPost;
import hu.schonherz.blog.service.api.service.BlogService;
import hu.schonherz.blog.service.api.user.vo.User;
import hu.schonherz.blog.service.blog.convert.BlogPostToDTO;
import hu.schonherz.blog.service.blog.convert.DTOToBlogPost;

public class BlogServiceImpl implements BlogService {

    public BlogServiceImpl() {
    }
    
    @Override
    public List<BlogPost> getAllBlogPostHeader() {
        List<BlogPost> t = new ArrayList<>();
        
        List<PostHeaderDTO> headers = (List<PostHeaderDTO>) new PostHeaderDAO().findAllHeaders();
        
        for (PostHeaderDTO headerDTO : headers) {
            List<PostTagDTO> postTagsDTO = new PostTagDAO().findByPostId(headerDTO.getId());
            
            UserServiceImpl us = new UserServiceImpl();
            User author = us.findByUserId(headerDTO.getUser_id());
            
            t.add(new DTOToBlogPost(headerDTO, author, postTagsDTO).getBlogPost());
        }
        return t;
    }
    
    @Override
    public BlogPost getBlogPostById(int id) {
        PostHeaderDTO headerDTO = new PostHeaderDAO().findByPostId(id);
        List<PostTagDTO> postTagsDTO = new PostTagDAO().findByPostId(id);
        
        UserServiceImpl us = new UserServiceImpl();
        User poster = us.findByUserId(headerDTO.getUser_id());
        
        return new DTOToBlogPost(headerDTO, poster, postTagsDTO).getBlogPost();
    }
    
    @Override
    public int addNewBlogPost(BlogPost blogPost) {
        BlogPostToDTO conv;
        try {
            conv = new BlogPostToDTO(blogPost);
            return new PostHeaderDAO().save(conv.getHeaderDTO(), conv.getPostTagsDTO());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
}
