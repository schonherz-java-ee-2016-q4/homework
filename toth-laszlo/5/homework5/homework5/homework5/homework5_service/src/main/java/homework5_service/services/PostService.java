package homework5_service.services;

import java.util.ArrayList;
import java.util.Collection;

import homework5_data.dao.PostDAO;
import homework5_data.dto.PostDTO;
import homework5_service.vo.PostVO;

public class PostService {

        PostDAO dao = new PostDAO();
        PostVO vo = new PostVO();
        Collection<PostDTO> postsDTO = new ArrayList<>();
        Collection<PostVO> postsVO = new ArrayList<>();
        
        
        public Collection<PostVO> findAll() {       
            postsDTO=dao.findAll();
            for(PostDTO postDTO : postsDTO){
                postsVO.add(toVO(postDTO));
            }
            return postsVO;
        }


       
        public PostVO findById(int id) {
            vo=toVO(dao.findById(id));
            return vo;
        }



       
        public int save(PostVO postVO) {
            dao.save(toDTO(postVO));
            return 0;
        }



        public static PostDTO toDTO(PostVO postVO){
            PostDTO postDTO = new PostDTO();
            postDTO.setId(postVO.getId());
            postDTO.setHeader(postVO.getHeader());
            postDTO.setText(postVO.getText());
            postDTO.setUsername(postVO.getUsername());
            postDTO.setDate(postVO.getDate());
            postDTO.setTags(postVO.getTags());
            
            return postDTO;
        }
        
        public static PostVO toVO(PostDTO postDTO){
            if(postDTO==null) return null;
            PostVO postVO = new PostVO();
            postVO.setId(postDTO.getId());
            postVO.setHeader(postDTO.getHeader());
            postVO.setText(postDTO.getText());
            postVO.setUsername(postDTO.getUsername());
            postVO.setDate(postDTO.getDate());
            postVO.setTags(postDTO.getTags());
            return postVO;
        }

    

}
