package hu.schonherz.blog.service.api.service;

import java.util.List;

import hu.schonherz.blog.service.api.blog.vo.BlogPost;

public interface BlogService {

    List<BlogPost> getAllBlogPostHeader();
    BlogPost getBlogPostById(int id);
    int addNewBlogPost(BlogPost blogPost);
    
}
