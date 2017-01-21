package hu.schonherz.blog.service.mappers;

import hu.schonherz.blog.data.domain.PostEntity;
import hu.schonherz.blog.service.api.blogpost.vo.BlogPostVO;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Áron on 2017. 01. 21..
 */
public class PostMapper {
    private static Mapper mapper = new DozerBeanMapper();

    public static BlogPostVO toVo(PostEntity dto) {
        if (dto == null) {
            return null;
        }
        return mapper.map(dto, BlogPostVO.class);
    }

    public static PostEntity toDto(BlogPostVO vo) {
        if (vo == null) {
            return null;
        }
        return mapper.map(vo, PostEntity.class);
    }

    public static List<BlogPostVO> toVo(List<PostEntity> postDtos) {
        List<BlogPostVO> postVos = new ArrayList<>();

        for (PostEntity postDto : postDtos) {
            postVos.add(toVo(postDto));
        }
        return postVos;
    }

    public static List<PostEntity> toDto(List<BlogPostVO> postVos) {
        List<PostEntity> postDtos = new ArrayList<>();

        for (BlogPostVO postVo : postVos) {
            postDtos.add(toDto(postVo));
        }
        return postDtos;
    }
}
