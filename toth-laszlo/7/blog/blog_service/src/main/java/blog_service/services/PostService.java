package blog_service.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import blog_service.vo.PostVO;

@Service
public interface PostService {
	public Collection<PostVO> findAll();
	public PostVO findById(int id);
	public int post(PostVO post);
}
