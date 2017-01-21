package hu.schonherz.jee.service.mapper.post;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonherz.jee.core.entity.PostEntity;
import hu.schonherz.jee.service.client.api.vo.Post;

public class PostVoMapper {
    static Mapper mapper = new DozerBeanMapper();

    public static Post toVo(PostEntity postEntity) {
        if (postEntity == null) {
            return null;
        }
        return mapper.map(postEntity, Post.class);
    }

    public static PostEntity toEntity(Post post) {
        if (post == null) {
            return null;
        }
        return mapper.map(post, PostEntity.class);
    }

    public static List<Post> toVo(List<PostEntity> postEntities) {
        List<Post> rv = new ArrayList<>();
        for (PostEntity postEntity : postEntities) {
            rv.add(toVo(postEntity));
        }
        return rv;
    }

    public static List<PostEntity> toEntity(List<Post> posts) {
        List<PostEntity> rv = new ArrayList<>();
        for (Post post : posts) {
            rv.add(toEntity(post));
        }
        return rv;
    }
}