package hu.schonherz.blog.service;

import java.util.Collection;

import hu.schonherz.blog.service.api.user.dto.PostDTO;
import vo.PostVO;

public interface PostService {
    public int save(PostVO vo);
    
    Collection<PostDTO> findAll();
    
}
