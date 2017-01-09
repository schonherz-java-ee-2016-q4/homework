package hu.schonherz.blog.service.api.user.service;

import java.util.List;

import hu.schonherz.blog.service.api.user.exception.PostNotFoundException;
import hu.schonherz.blog.service.api.user.vo.PostVO;

public interface PostService {
    List<PostVO> findAll();
    PostVO findById(int id) throws PostNotFoundException;
    void add(PostVO postVO);
}
