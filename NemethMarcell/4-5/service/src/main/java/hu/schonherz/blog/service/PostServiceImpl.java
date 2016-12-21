package hu.schonherz.blog.service;

import java.util.Collection;

import hu.schonherz.blog.service.api.user.dao.PostDAO;
import hu.schonherz.blog.service.api.user.dto.PostDTO;
import vo.PostVO;

public class PostServiceImpl implements PostService {
    PostDAO dao = new PostDAO();
    @Override
    public int save(PostVO vo) {
        dao.save(toDTO(vo));
        return 0;
    }

    @Override
    public Collection<PostDTO> findAll() {
        return dao.findAll();
    }
    
    private static PostDTO toDTO(PostVO vo){
        PostDTO dto = new PostDTO();
        
        dto.setName(vo.getName());
        dto.setTitle(vo.getTitle());
        dto.setTextArea(vo.getTextArea());
        
        return dto;
    }
}
