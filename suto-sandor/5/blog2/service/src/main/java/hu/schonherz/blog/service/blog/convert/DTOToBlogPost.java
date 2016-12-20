package hu.schonherz.blog.service.blog.convert;


import hu.schonherz.blog.service.api.blog.vo.PostBlog;
import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostBlogDTO;


public class DTOToBlogPost {

    private PostBlog blogPost;
    
    public DTOToBlogPost(PostBlogDTO postblogDTO) {
        blogPost = new PostBlog();
        
        blogPost.setId(postblogDTO.getId());
        blogPost.setUsername(postblogDTO.getUsername());
        blogPost.setHeader(postblogDTO.getHeader());
        blogPost.setCreated(postblogDTO.getCreated().toString());
        blogPost.setContent(postblogDTO.getContent() == null ? "" : postblogDTO.getContent());
        blogPost.setTags(postblogDTO.getTags());
    }

    public PostBlog getBlogPost() {
        return blogPost;
    }
}
