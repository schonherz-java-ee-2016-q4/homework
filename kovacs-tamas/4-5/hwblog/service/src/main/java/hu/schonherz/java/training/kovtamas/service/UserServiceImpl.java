package hu.schonherz.java.training.kovtamas.service;

import hu.schonherz.java.training.kovtamas.data.dao.UserDao;
import hu.schonherz.java.training.kovtamas.data.dto.UserDto;
import hu.schonherz.java.training.kovtamas.service.converter.VoDtoConverter;

import hu.schonherz.java.training.kovtamas.serviceapi.user.exception.UserNotFoundException;
import hu.schonherz.java.training.kovtamas.serviceapi.user.service.UserService;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.UserVo;
import java.util.Collection;
import java.util.HashSet;

public class UserServiceImpl implements UserService {

    private static final UserDao dao;

    static {
        dao = new UserDao();
    }

    public UserServiceImpl() {
    }

    @Override
    public Collection<UserVo> findAllUser() {
        Collection<UserDto> allUserDtos = dao.findAll();
        Collection<UserVo> allUserVos = new HashSet<>();
        allUserDtos.forEach(dto -> allUserVos.add(VoDtoConverter.convert(dto)));
        return allUserVos;
    }

    @Override
    public UserVo findUserByName(String name) throws UserNotFoundException {
        UserDto dto = dao.findByUsername(name);
        if (dto == null) {
            throw new UserNotFoundException();
        }
        return VoDtoConverter.convert(dto);
    }

    @Override
    public void addUser(UserVo user) {
        UserDto dto = VoDtoConverter.convert(user);
        dao.save(dto);
    }

}
