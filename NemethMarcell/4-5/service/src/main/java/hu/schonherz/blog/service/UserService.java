package hu.schonherz.blog.service;

import java.util.Collection;

import hu.schonherz.blog.service.api.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import vo.UserVO;

public interface UserService {
    UserDTO findByUserName(String username) throws UserNotFoundException;
    
    Collection<UserDTO> findAll();
    
    public int save(UserVO vo);
}
