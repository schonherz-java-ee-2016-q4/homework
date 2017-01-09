package blog_service.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog_data.dao.PostDAO;
import blog_data.dto.PostDTO;
import blog_service.vo.PostVO;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostDAO postDAO;
	
	@Autowired
	PostVO postVO;
	
	@Override
	public Collection<PostVO> findAll() {
		Collection<PostVO> postsVO = new ArrayList<>();
		Collection<PostDTO> postsDTO = new ArrayList<>();
		postsDTO=postDAO.findAll();
		for(PostDTO post : postsDTO ){
			postsVO.add(toVO(post));
		}
		return postsVO;
	}

	@Override
	public PostVO findById(int id) {
		return toVO(postDAO.findById(id));
	}

	@Override
	public int post(PostVO post) {
		return postDAO.post(toDTO(post));
	}

	public static PostVO toVO(PostDTO dto){
		PostVO vo = new PostVO();
		vo.setId(dto.getId());
		vo.setUsername(dto.getUsername());
		vo.setTitle(dto.getTitle());
		vo.setText(dto.getText());
		vo.setTags(dto.getTags());
		vo.setPost_date(dto.getPost_date());
		return vo;
	}
	
	public static PostDTO toDTO(PostVO vo){
		PostDTO dto = new PostDTO();
		dto.setId(vo.getId());
		dto.setUsername(vo.getUsername());
		dto.setTitle(vo.getTitle());
		dto.setText(vo.getText());
		dto.setTags(vo.getTags());
		dto.setPost_date(vo.getPost_date());
		return dto;
	}
}
