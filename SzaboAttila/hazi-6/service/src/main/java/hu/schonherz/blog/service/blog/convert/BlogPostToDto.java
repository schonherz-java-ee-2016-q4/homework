package hu.schonherz.blog.service.blog.convert;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.blog.data.blog.dto.PostDto;
import hu.schonherz.blog.data.blog.dto.PostTagDto;
import hu.schonherz.blog.service.api.blog.vo.BlogPost;

public class BlogPostToDto {

    private PostDto postDto;
    private List<PostTagDto> postTagsDto;
    
    public BlogPostToDto(BlogPost blogPost, int user_id) throws ParseException {
        postDto = new PostDto();
        postDto.setPosted( new Timestamp(new SimpleDateFormat("yyyy-MM-dd kk:mm").parse(blogPost.getPosted()).getTime()) );
        postDto.setTitle(blogPost.getTitle());
        postDto.setUser_id(user_id);
        postDto.setContent(blogPost.getContent());

        postTagsDto = new ArrayList<>();
        for (String tag : blogPost.getTags()) {
            PostTagDto e = new PostTagDto();
            e.setTag(tag);
            postTagsDto.add(e);
        }
    }

    public PostDto getPostDto() {
        return postDto;
    }

    public List<PostTagDto> getPostTagsDto() {
        return postTagsDto;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BlogPostToDto [postDto=");
        builder.append(postDto);
        builder.append(", postTagsDto=");
        builder.append(postTagsDto);
        builder.append("]");
        return builder.toString();
    }
}
