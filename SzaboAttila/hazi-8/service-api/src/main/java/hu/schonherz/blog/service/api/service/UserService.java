package hu.schonherz.blog.service.api.service;

import java.util.List;

import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.vo.UserVo;

public interface UserService {

	List<UserVo> findAllUser();
	UserVo findUserByUsername(String name) throws UserNotFoundException;
	UserVo findByUserId(int id);
	boolean switchUserStatus(String username);
	
	void addNewUser(UserVo user);
}
