package hu.schonherz.blog.service.api.user.dao;


import hu.schonherz.blog.service.api.user.pojo.User;

import java.util.Collection;

public interface UserDAO {

    public Collection<User> findAll();

    public User findByUserName(String username);

    public void createUser(User user);

}
