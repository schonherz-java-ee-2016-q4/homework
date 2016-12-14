package hu.schonherz.blog.service.blog.convert;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.blog.service.api.blog.vo.BlogPost;
import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostHeaderDTO;
import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostTagDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dao.LoginDAO;

public class BlogPostToDTO {

    private PostHeaderDTO headerDTO;
    private List<PostTagDTO> postTagsDTO;
    
    public BlogPostToDTO(BlogPost blogPost) throws ParseException {
        
        headerDTO = new PostHeaderDTO();
        headerDTO.setPosted( new Date ( new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(blogPost.getPosted()).getTime() ) );
        headerDTO.setTitle(blogPost.getTitle());
        headerDTO.setUser_id(new LoginDAO().findByUserName(blogPost.getAuthor().getLogin().getUsername()).getUser_id());
        headerDTO.setContent(blogPost.getContent());

        postTagsDTO = new ArrayList<>();
        for (String tag : blogPost.getTags()) {
            PostTagDTO e = new PostTagDTO();
            e.setTag(tag);
            postTagsDTO.add(e);
        }
    }

    public PostHeaderDTO getHeaderDTO() {
        return headerDTO;
    }

    public List<PostTagDTO> getPostTagsDTO() {
        return postTagsDTO;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BlogPostToDTO [headerDTO=");
        builder.append(headerDTO);
        builder.append(", postTagsDTO=");
        builder.append(postTagsDTO);
        builder.append("]");
        return builder.toString();
    }

    
    
}
