package hu.schonherz.blog.service.api.user.service;

import hu.schonherz.blog.service.api.user.vo.UserVO;

import java.util.List;

public interface UserService {

    List<UserVO> findAllUser();

    UserVO findUserByName(String name);

    UserVO findUserById(int id);

    void saveUser(UserVO user);

    boolean switchUserStatus(String username);
}
