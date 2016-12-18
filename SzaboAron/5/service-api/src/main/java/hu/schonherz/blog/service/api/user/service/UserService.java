package hu.schonherz.blog.service.api.user.service;

import java.util.List;

import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.vo.UserVO;

public interface UserService {

    public List<UserVO> findAllUser();

    public UserVO findUserByName(String name) throws UserNotFoundException;

    public void saveUser(UserVO user);
}
