package hu.schonherz.blog.service.api.service;

import java.util.List;

import hu.schonherz.blog.service.api.blog.vo.PostBlog;

public interface BlogService {

    List<PostBlog> getAllBlogPost();
    PostBlog getBlogPostById(int id);
    int addNewBlogPost(PostBlog blogPost);
    
}
