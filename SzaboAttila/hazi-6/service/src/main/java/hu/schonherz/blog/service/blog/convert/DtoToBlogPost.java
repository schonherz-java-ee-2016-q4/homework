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
    
    public DtoToBlogPost(PostDto headerDTO, User author, List<PostTagDto> postTagsDTO) {
        blogPost = new BlogPost();
        
        blogPost.setId(headerDTO.getId());
        blogPost.setPosted(headerDTO.getPosted().toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy.MM.dd kk:mm")));
        blogPost.setAuthor(author);
        blogPost.setContent(headerDTO.getContent());
        blogPost.setTitle(headerDTO.getTitle());
        
        List<String> tags = new ArrayList<>();
        for (PostTagDto postTag : postTagsDTO) {
            tags.add(postTag.getTag());
        }
        blogPost.setTags(tags);
    }

    public BlogPost getBlogPost() {
        return blogPost;
    }
}
