package hu.schonherz.blog.service.blog.convert;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.blog.data.blog.dto.PostDto;
import hu.schonherz.blog.data.blog.dto.PostTagDto;
import hu.schonherz.blog.service.api.blog.vo.BlogPost;
import hu.schonherz.blog.service.api.user.vo.User;

public class DtoToBlogPost {

    private BlogPost blogPost;
    
    public DtoToBlogPost(PostDto postDto, User author, List<PostTagDto> postTagsDto) {
        blogPost = new BlogPost();
        
        blogPost.setId(postDto.getId());
        blogPost.setPosted(postDto.getPosted().toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy.MM.dd kk:mm")));
        blogPost.setAuthor(author);
        blogPost.setContent(postDto.getContent());
        blogPost.setTitle(postDto.getTitle());
        
        List<String> tags = new ArrayList<>();
        for (PostTagDto postTag : postTagsDto) {
            tags.add(postTag.getTag());
        }
        blogPost.setTags(tags);
    }

    public BlogPost getBlogPost() {
        return blogPost;
    }
}
