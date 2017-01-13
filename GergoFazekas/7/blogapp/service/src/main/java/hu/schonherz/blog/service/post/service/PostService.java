package hu.schonherz.blog.service.post.service;

import hu.schonherz.blog.service.post.exception.PostNotFoundException;
import hu.schonherz.blog.service.post.vo.PostVO;

import java.util.List;

/**
 * Created by Geri on 2017. 01. 04..
 */
public interface PostService {
    List<PostVO> findAll();
    PostVO findById(int id) throws PostNotFoundException;
    void add(PostVO postVO);
}
