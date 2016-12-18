package hu.schonherz.blog.service.blog.convert;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.blog.data.blog.dto.PostDto;
import hu.schonherz.blog.data.blog.dto.PostTagDto;
import hu.schonherz.blog.data.user.dao.LoginDao;
import hu.schonherz.blog.service.api.blog.vo.BlogPost;

public class BlogPostToDto {

    private PostDto headerDTO;
    private List<PostTagDto> postTagsDTO;
    
    public BlogPostToDto(BlogPost blogPost) throws ParseException {
        
        headerDTO = new PostDto();
        headerDTO.setPosted( new Timestamp(new SimpleDateFormat("yyyy-MM-dd kk:mm").parse(blogPost.getPosted()).getTime()) );
        headerDTO.setTitle(blogPost.getTitle());
        headerDTO.setUser_id(new LoginDao().findByUserName(blogPost.getAuthor().getLogin().getUsername()).getUser_id());
        headerDTO.setContent(blogPost.getContent());

        postTagsDTO = new ArrayList<>();
        for (String tag : blogPost.getTags()) {
            PostTagDto e = new PostTagDto();
            e.setTag(tag);
            postTagsDTO.add(e);
        }
    }

    public PostDto getHeaderDTO() {
        return headerDTO;
    }

    public List<PostTagDto> getPostTagsDTO() {
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
