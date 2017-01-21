package hu.schonherz.jee.service.client.api.service.user;

import java.util.List;

import hu.schonherz.jee.service.client.api.vo.User;

public interface UserService {
    User findByUsername(String username);
    User registrationUser(User user);
    List<User> findAll();
}
