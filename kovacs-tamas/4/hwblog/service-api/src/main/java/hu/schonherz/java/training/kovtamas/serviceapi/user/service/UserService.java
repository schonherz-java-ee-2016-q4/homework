package hu.schonherz.java.training.kovtamas.serviceapi.user.service;

import hu.schonherz.java.training.kovtamas.serviceapi.user.exception.UserNotFoundException;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.User;
import java.util.List;

public interface UserService {

    public List<User> findAllUser();

    User findUserByName(String name) throws UserNotFoundException;
}
