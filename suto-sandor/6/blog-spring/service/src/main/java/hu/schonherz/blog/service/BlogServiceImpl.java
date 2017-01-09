package hu.schonherz.blog.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.schonherz.blog.service.api.blog.vo.PostBlog;
import hu.schonherz.blog.service.api.service.BlogService;
import hu.schonherz.blog.service.api.user.service.data.blog.dao.PostBlogDAO;
import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostBlogDTO;
import hu.schonherz.blog.service.blog.convert.BlogPostToDTO;
import hu.schonherz.blog.service.blog.convert.DTOToBlogPost;

public class BlogServiceImpl implements BlogService {

    public BlogServiceImpl() {
    }
    
    @Override
    public List<PostBlog> getAllBlogPost() {
        List<PostBlog> posts = new ArrayList<>();
        
        Collection<PostBlogDTO> blogs = new PostBlogDAO().findAll();
        
        for (PostBlogDTO postblogdto : blogs) {
            posts.add(new DTOToBlogPost(postblogdto).getBlogPost());
        }
        return posts;
    }
    
    @Override
    public PostBlog getBlogPostById(int id) {
        PostBlogDTO blogDTO = new PostBlogDAO().findById(id);

        return new DTOToBlogPost(blogDTO).getBlogPost();
    }
    
    @Override
    public int addNewBlogPost(PostBlog blogPost) {
        try {
            BlogPostToDTO conv = new BlogPostToDTO(blogPost);
            return new PostBlogDAO().save(conv.getPostBlogto());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
}
