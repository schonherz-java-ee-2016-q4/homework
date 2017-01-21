package hu.schonherz.blog.service.blogpostservice;

import hu.schonherz.blog.data.domain.PostEntity;
import hu.schonherz.blog.data.repository.PostRepository;
import hu.schonherz.blog.service.api.blogpost.service.BlogPostService;
import hu.schonherz.blog.service.api.blogpost.vo.BlogPostVO;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.mappers.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class BlogPostServiceImpl implements BlogPostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserService userService;

    @Override
    public void savePost(BlogPostVO vo) {
        postRepository.save(PostMapper.toDto(vo));
    }

    @Override
    public Collection<BlogPostVO> findAllPost() {
        List<PostEntity> posts = null;

        posts = postRepository.findAll();

        return PostMapper.toVo(posts);
    }

    @Override
    public BlogPostVO findPostById(int id) {
        return PostMapper.toVo(postRepository.findOne(id));
    }

}
