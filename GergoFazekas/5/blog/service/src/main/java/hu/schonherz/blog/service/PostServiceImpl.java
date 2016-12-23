package hu.schonherz.blog.service;

import java.util.ArrayList;
import java.util.List;

import hu.schonherz.blog.data.dao.GenericDAO;
import hu.schonherz.blog.data.dao.PostDAO;
import hu.schonherz.blog.data.dto.PostDTO;
import hu.schonherz.blog.service.api.user.service.PostService;
import hu.schonherz.blog.service.api.user.vo.PostVO;

public class PostServiceImpl implements PostService{

    GenericDAO<PostDTO> postDAO = new PostDAO();
    
    @Override
    public List<PostVO> findAll() {
        List<PostVO> posts = new ArrayList<>();
        for (PostDTO postDTO : postDAO.findAll()) {
            posts.add(toVO(postDTO));
        }
        return posts;
    }

    @Override
    public void add(PostVO postVO) {
        postDAO.save(toDTO(postVO));
    }
    
    private static PostDTO toDTO (PostVO postVO) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(postVO.getId());
        postDTO.setTitle(postVO.getTitle());
        postDTO.setContent(postVO.getContent());
        postDTO.setPublished(postVO.getPublished());
        postDTO.setAuthorID(postVO.getAuthorID());
        return postDTO;
    }
    
    private static PostVO toVO (PostDTO postDTO) {
        PostVO postVO = new PostVO();
        postVO.setId(postDTO.getId());
        postVO.setTitle(postDTO.getTitle());
        postVO.setContent(postDTO.getContent());
        postVO.setPublished(postVO.getPublished());
        postVO.setAuthorID(postDTO.getAuthorID());
        return postVO;
    }

}
