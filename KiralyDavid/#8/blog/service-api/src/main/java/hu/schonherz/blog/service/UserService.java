package hu.schonherz.blog.service;

import hu.schonherz.blog.vo.UserVO;

import java.util.Collection;

public interface UserService {
    UserVO findByUserName(String username);
    
    Collection<UserVO> findAll();
    
    void save(UserVO vo);
}
