package hu.schonherz.jee.service.mapper.user;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonherz.jee.core.entity.UserEntity;
import hu.schonherz.jee.service.client.api.vo.User;

public class UserVoMapper {
    static Mapper mapper = new DozerBeanMapper();

    public static User toVo(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        return mapper.map(userEntity, User.class);
    }

    public static UserEntity toEntity(User user) {
        if (user == null) {
            return null;
        }
        return mapper.map(user, UserEntity.class);
    }

    public static List<User> toVo(List<UserEntity> userEntities) {
        List<User> rv = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            rv.add(toVo(userEntity));
        }
        return rv;
    }

    public static List<UserEntity> toEntity(List<User> users) {
        List<UserEntity> rv = new ArrayList<>();
        for (User user : users) {
            rv.add(toEntity(user));
        }
        return rv;
    }
}
