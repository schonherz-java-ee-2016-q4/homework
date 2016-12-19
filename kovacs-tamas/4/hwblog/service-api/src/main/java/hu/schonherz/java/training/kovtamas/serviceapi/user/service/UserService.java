package hu.schonherz.java.training.kovtamas.serviceapi.user.service;

import hu.schonherz.java.training.kovtamas.serviceapi.user.exception.UserNotFoundException;
import hu.schonherz.java.training.kovtamas.serviceapi.user.oldvo.User;
import java.util.List;

public interface UserService {

    List<User> findAllUser();

    User findUserByName(String name) throws UserNotFoundException;

    void addUser(User user);
}
