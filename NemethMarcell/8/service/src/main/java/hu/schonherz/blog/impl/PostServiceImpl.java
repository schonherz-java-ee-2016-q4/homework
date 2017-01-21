package hu.schonherz.blog.impl;


import hu.schonherz.blog.core.domain.PostEntity;
import hu.schonherz.blog.core.repository.PostRepository;
import hu.schonherz.blog.mapper.PostMapper;
import hu.schonherz.blog.service.PostService;
import hu.schonherz.blog.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;


    @Override
    public void save(PostVO vo) {
        postRepository.save(PostMapper.toDto(vo));

    }
    @Override
    public Collection<PostVO> findAll()  {
        List<PostEntity> posts = null;

        posts = postRepository.findAll();

        return PostMapper.toVo(posts);
    }
}
