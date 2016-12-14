package hu.schonherz.blog.service.blog.convert;

import java.util.ArrayList;
import java.util.List;

import hu.schonherz.blog.service.api.blog.vo.BlogPost;
import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostHeaderDTO;
import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostTagDTO;
import hu.schonherz.blog.service.api.user.vo.User;

public class DTOToBlogPost {

    private BlogPost blogPost;
    
    public DTOToBlogPost(PostHeaderDTO headerDTO, User author, List<PostTagDTO> postTagsDTO) {
        blogPost = new BlogPost();
        
        blogPost.setId(headerDTO.getId());
        blogPost.setPosted(headerDTO.getPosted().toString());
        blogPost.setAuthor(author);
        blogPost.setContent(headerDTO.getContent());
        blogPost.setTitle(headerDTO.getTitle());
        
        List<String> tags = new ArrayList<>();
        for (PostTagDTO postTag : postTagsDTO) {
            tags.add(postTag.getTag());
        }
        blogPost.setTags(tags);
    }

    public BlogPost getBlogPost() {
        return blogPost;
    }
}
