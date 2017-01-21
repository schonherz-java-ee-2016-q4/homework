package hu.schonherz.jee.service.mapper.role;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonherz.jee.core.entity.RoleEntity;
import hu.schonherz.jee.service.client.api.vo.Role;

public class RoleVoMapper {

    static Mapper mapper = new DozerBeanMapper();

    public static Role toVo(RoleEntity role) {
        if (role == null) {
            return null;
        }
        return mapper.map(role, Role.class);
    }

    public static RoleEntity toEntity(Role role) {
        if (role == null) {
            return null;
        }
        return mapper.map(role, RoleEntity.class);
    }

    public static List<Role> toVo(List<RoleEntity> roleEntities) {
        List<Role> rv = new ArrayList<>();
        for (RoleEntity roleEntity : roleEntities) {
            rv.add(toVo(roleEntity));
        }
        return rv;
    }

    public static List<RoleEntity> toEntity(List<Role> roles) {
        List<RoleEntity> rv = new ArrayList<>();
        for (Role role : roles) {
            rv.add(toEntity(role));
        }
        return rv;
    }
}
