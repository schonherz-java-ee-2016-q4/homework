package hu.schonherz.blog.service;

import java.util.Collection;

import hu.schonherz.blog.service.api.user.dao.PostDAO;
import hu.schonherz.blog.service.api.user.dto.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vo.PostVO;
@Service
public class PostServiceImpl implements PostService {
        @Autowired
        private PostDAO dao;
    @Override
    public int save(PostVO vo) {
       return dao.save(toDTO(vo));

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
