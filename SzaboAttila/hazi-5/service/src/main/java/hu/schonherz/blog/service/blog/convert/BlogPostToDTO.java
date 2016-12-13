package hu.schonherz.blog.service.blog.convert;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.blog.service.api.blog.vo.BlogPost;
import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostContentDTO;
import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostHeaderDTO;
import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostTagDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dao.LoginDAO;

public class BlogPostToDTO {

    private PostHeaderDTO header_dto;
    private PostContentDTO content_dto;
    private List<PostTagDTO> postTags_dto;
    
    public BlogPostToDTO(BlogPost blogPost) throws ParseException {
        
        header_dto = new PostHeaderDTO();
        header_dto.setPosted( new Date ( new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(blogPost.getPosted()).getTime() ) );
        header_dto.setTitle(blogPost.getTitle());
        header_dto.setUser_id(new LoginDAO().findByUserName(blogPost.getPoster().getLogin().getUsername()).getUser_id());
        
        
        content_dto = new PostContentDTO();
        content_dto.setText(blogPost.getText());
        
        postTags_dto = new ArrayList<>();
        for (String tag : blogPost.getTags()) {
            PostTagDTO e = new PostTagDTO();
            e.setTag(tag);
            postTags_dto.add(e);
        }
    }

    public PostHeaderDTO getHeader_dto() {
        return header_dto;
    }

    public PostContentDTO getContent_dto() {
        return content_dto;
    }

    public List<PostTagDTO> getPostTags_dto() {
        return postTags_dto;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BlogPostToDTO [header_dto=");
        builder.append(header_dto);
        builder.append(", content_dto=");
        builder.append(content_dto);
        builder.append(", postTags_dto=");
        builder.append(postTags_dto);
        builder.append("]");
        return builder.toString();
    }
    
    
    
}
