package hu.schonherz.blog.service.blog.convert;

import java.util.ArrayList;
import java.util.List;

import hu.schonherz.blog.service.api.blog.vo.BlogPost;
import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostContentDTO;
import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostHeaderDTO;
import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostTagDTO;
import hu.schonherz.blog.service.api.user.vo.User;

public class DTOToBlogPost {

    private BlogPost blogPost;
    
    public DTOToBlogPost(PostHeaderDTO header_dto, PostContentDTO content_dto, User poster, List<PostTagDTO> postTags_dto) {
        blogPost = new BlogPost();
        
        blogPost.setId(header_dto.getId());
        blogPost.setPosted(header_dto.getPosted().toString());
        blogPost.setPoster(poster);
        blogPost.setText( content_dto == null ? "" : content_dto.getText());
        blogPost.setTitle(header_dto.getTitle());
        
        List<String> tags = new ArrayList<>();
        for (PostTagDTO postTag : postTags_dto) {
            tags.add(postTag.getTag());
        }
        blogPost.setTags(tags);
    }

    public BlogPost getBlogPost() {
        return blogPost;
    }
}
