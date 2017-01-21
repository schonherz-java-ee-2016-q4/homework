package hu.schonherz.blog.service.api.blogpost.service;

import hu.schonherz.blog.service.api.blogpost.vo.BlogPostVO;

import java.util.Collection;

public interface BlogPostService {
    Collection<BlogPostVO> findAllPost();

    BlogPostVO findPostById(int id);

    void savePost(BlogPostVO post);
}
