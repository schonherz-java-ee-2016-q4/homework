package hu.schonherz.blog.service.post.service;

import hu.schonherz.blog.data.GenericDAO;
import hu.schonherz.blog.data.post.PostDAO;
import hu.schonherz.blog.data.post.PostDTO;
import hu.schonherz.blog.service.post.exception.PostNotFoundException;
import hu.schonherz.blog.service.post.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geri on 2017. 01. 04..
 */
@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private GenericDAO<PostDTO> postDAO;

    @Override
    public List<PostVO> findAll() {
        List<PostVO> posts = new ArrayList<>();
        for (PostDTO postDTO : postDAO.findAll()) {
            posts.add(toVO(postDTO));
        }
        return posts;
    }

    @Override
    public PostVO findById(int id) throws PostNotFoundException {
        PostDTO postDTO;
        postDTO = postDAO.findById(id);
        if (postDTO != null) {
            return toVO(postDTO);
        }
        throw new PostNotFoundException();
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
