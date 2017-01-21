package hu.schonherz.blog.service.api.user.service;

import hu.schonherz.blog.service.api.user.vo.UserVO;

import java.util.Collection;

public interface UserService {

    Collection<UserVO> findAllUser();

    UserVO findUserByName(String name);

    void saveUser(UserVO user);

    boolean switchUserStatus(String username);
}
