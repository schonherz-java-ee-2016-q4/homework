package hu.schonherz.blog.service.api.blogpost.service;

import java.util.List;

import hu.schonherz.blog.service.api.blogpost.vo.BlogPostVO;

public interface BlogPostService {
    List<BlogPostVO> findAllPost();

    BlogPostVO findPostById(int id);

    void savePost(BlogPostVO post);
}
