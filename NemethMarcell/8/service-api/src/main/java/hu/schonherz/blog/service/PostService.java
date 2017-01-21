package hu.schonherz.blog.service;

import hu.schonherz.blog.vo.PostVO;

import java.util.Collection;

public interface PostService {
    void save(PostVO vo);
    
    Collection<PostVO> findAll();
    
}
