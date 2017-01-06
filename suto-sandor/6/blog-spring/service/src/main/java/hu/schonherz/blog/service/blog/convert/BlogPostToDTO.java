package hu.schonherz.blog.service.blog.convert;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import hu.schonherz.blog.service.api.blog.vo.PostBlog;
import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostBlogDTO;


public class BlogPostToDTO {

    private PostBlogDTO blogDTO;
    
    public BlogPostToDTO(PostBlog postBlog) throws ParseException {
        
        blogDTO = new PostBlogDTO();
        blogDTO.setHeader(postBlog.getHeader());
        blogDTO.setUsername(postBlog.getUsername());
        blogDTO.setContent(postBlog.getContent());
        blogDTO.setCreated( new Date ( new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(postBlog.getCreated()).getTime() ) );
        blogDTO.setTags(postBlog.getTags());
    }

    public PostBlogDTO getPostBlogto() {
        return blogDTO;
    }
  
    
}
