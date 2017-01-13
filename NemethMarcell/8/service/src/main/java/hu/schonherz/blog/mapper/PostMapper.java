package hu.schonherz.blog.mapper;

import hu.schonherz.blog.core.domain.PostEntity;
import hu.schonherz.blog.vo.PostVO;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;


public class PostMapper {
    private static Mapper mapper = new DozerBeanMapper();

    public static PostVO toVo(PostEntity dto){
        if(dto == null){
            return null;
        }
        return mapper.map(dto,PostVO.class);
    }

    public static PostEntity toDto(PostVO vo){
        if(vo == null){
            return null;
        }
        return mapper.map(vo,PostEntity.class);
    }

    public static List<PostVO> toVo(List<PostEntity> postDtos){
        List<PostVO> postVos = new ArrayList<>();

        for(PostEntity postDto: postDtos){
            postVos.add(toVo(postDto));
        }
        return postVos;
    }
    public static List<PostEntity> toDto(List<PostVO> postVos){
        List<PostEntity> postDtos = new ArrayList<>();

        for(PostVO postVo : postVos){
            postDtos.add(toDto(postVo));
        }
        return postDtos;
    }
}
