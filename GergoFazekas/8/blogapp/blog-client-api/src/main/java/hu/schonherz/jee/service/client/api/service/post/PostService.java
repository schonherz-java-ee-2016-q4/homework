package hu.schonherz.jee.service.client.api.service.post;

import java.util.List;

import hu.schonherz.jee.service.client.api.vo.Post;

public interface PostService {
    
    Post findById(Long id);
    List<Post> findAll();
    Post savePost(Post post);
    
}
