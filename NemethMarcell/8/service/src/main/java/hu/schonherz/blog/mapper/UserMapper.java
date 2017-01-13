package hu.schonherz.blog.mapper;


import hu.schonherz.blog.core.domain.UserEntity;
import hu.schonherz.blog.vo.UserVO;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    private static Mapper mapper = new DozerBeanMapper();

    public static UserVO toVo(UserEntity dto){
        if(dto == null){
            return null;
        }
        return mapper.map(dto,UserVO.class);
    }

    public static UserEntity toDto(UserVO vo){
        if(vo == null){
            return null;
        }
        return mapper.map(vo,UserEntity.class);
    }

    public static List<UserVO> toVo(List<UserEntity> userDtos){
        List<UserVO> userVos = new ArrayList<>();

        for(UserEntity userDto: userDtos){
            userVos.add(toVo(userDto));
        }
        return userVos;
    }

    public static List<UserEntity> toDto(List<UserVO> userVos){
        List<UserEntity> userDtos = new ArrayList<>();

        for(UserVO userVo : userVos){
            userDtos.add(toDto(userVo));
        }

        return userDtos;
    }
}
