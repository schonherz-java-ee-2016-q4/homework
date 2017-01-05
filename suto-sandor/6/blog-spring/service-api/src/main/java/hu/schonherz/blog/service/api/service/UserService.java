package hu.schonherz.blog.service.api.service;

import java.util.List;

import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.vo.User;

public interface UserService {

	List<User> findAllUser();

	User findUserByName(String name) throws UserNotFoundException;
	void addNewUser(User user);
}
