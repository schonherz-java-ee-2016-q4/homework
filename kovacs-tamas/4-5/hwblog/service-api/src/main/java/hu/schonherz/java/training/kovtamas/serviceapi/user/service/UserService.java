package hu.schonherz.java.training.kovtamas.serviceapi.user.service;

import hu.schonherz.java.training.kovtamas.serviceapi.user.exception.UserNotFoundException;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.UserVo;
import java.util.Collection;

public interface UserService {

    Collection<UserVo> findAllUser();

    UserVo findUserByName(String name) throws UserNotFoundException;

    void addUser(UserVo user);
}
