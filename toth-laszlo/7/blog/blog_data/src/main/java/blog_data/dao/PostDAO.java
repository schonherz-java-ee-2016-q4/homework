package blog_data.dao;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import blog_data.dto.PostDTO;

@Repository
public interface PostDAO {
	public PostDTO findById(int id);
	public Collection<PostDTO> findAll();
	public int post(PostDTO post);
}
