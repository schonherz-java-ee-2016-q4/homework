package hu.schonherz.blog.service.user.service;

import hu.schonherz.blog.service.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.user.vo.UserVO;

import java.util.List;

/**
 * Created by Geri on 2017. 01. 04..
 */
public interface UserService {
    List<UserVO> findAll();
    UserVO findByUsername(String name) throws UserNotFoundException;
    void add(UserVO userVO);
    void changeStatus(int id);
}
