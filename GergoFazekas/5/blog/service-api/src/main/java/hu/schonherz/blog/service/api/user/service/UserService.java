package hu.schonherz.blog.service.api.user.service;

import java.util.List;

import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.vo.UserVO;

public interface UserService {

	List<UserVO> findAll();

	UserVO findByUsername(String name) throws UserNotFoundException;

    void add(UserVO userVO);

}
