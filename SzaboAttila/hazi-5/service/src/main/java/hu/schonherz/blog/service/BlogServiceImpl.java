package hu.schonherz.blog.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.blog.service.api.blog.vo.BlogPost;
import hu.schonherz.blog.service.api.service.BlogService;
import hu.schonherz.blog.service.api.user.service.data.blog.dao.PostContentDAO;
import hu.schonherz.blog.service.api.user.service.data.blog.dao.PostHeaderDAO;
import hu.schonherz.blog.service.api.user.service.data.blog.dao.PostTagDAO;
import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostContentDTO;
import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostHeaderDTO;
import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostTagDTO;
import hu.schonherz.blog.service.api.user.vo.User;
import hu.schonherz.blog.service.blog.convert.BlogPostToDTO;
import hu.schonherz.blog.service.blog.convert.DTOToBlogPost;

public class BlogServiceImpl implements BlogService {

    public BlogServiceImpl() {
    }
    
    @Override
    public List<BlogPost> getAllBlogPostHeader() {
        List<BlogPost> t = new ArrayList<>();
        
        List<PostHeaderDTO> headers = (List<PostHeaderDTO>) new PostHeaderDAO().findAll();
        
        for (PostHeaderDTO header_dto : headers) {
            //we dont want to load the whole post everytime
            PostContentDTO content_dto = null;
            List<PostTagDTO> postTags_dto = new PostTagDAO().findByPostId(header_dto.getId());
            
            UserServiceImpl us = new UserServiceImpl();
            User poster = us.findByUserId(header_dto.getUser_id());
            
            t.add(new DTOToBlogPost(header_dto, content_dto, poster, postTags_dto).getBlogPost());
        }
        return t;
    }
    
    @Override
    public BlogPost getBlogPostById(int id) {
        PostHeaderDTO header_dto = new PostHeaderDAO().findByPostId(id);
        PostContentDTO content_dto = new PostContentDAO().findByPostId(id);
        List<PostTagDTO> postTags_dto = new PostTagDAO().findByPostId(id);
        
        UserServiceImpl us = new UserServiceImpl();
        User poster = us.findByUserId(header_dto.getUser_id());
        
        return new DTOToBlogPost(header_dto, content_dto, poster, postTags_dto).getBlogPost();
    }
    
    @Override
    public int addNewBlogPost(BlogPost blogPost) {
        BlogPostToDTO conv;
        try {
            conv = new BlogPostToDTO(blogPost);
            return new PostHeaderDAO().save(conv.getHeader_dto(), conv.getContent_dto(), conv.getPostTags_dto());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
}
