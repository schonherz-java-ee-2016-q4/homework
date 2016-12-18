package hu.schonherz.blog.service.api.service;

import java.util.List;

import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.vo.User;

public interface UserService {

	List<User> findAllUser();
	User findUserByUsername(String name) throws UserNotFoundException;
	User findByUserId(int id);
	
	void addNewUser(User user);
}
