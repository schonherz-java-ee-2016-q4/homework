package hu.schonherz.blog.service;


import hu.schonherz.blog.service.api.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.vo.UserVO;

import java.util.Collection;

public interface UserService {

    UserDTO findByUserName(String username) throws UserNotFoundException;

    Collection<UserDTO> findAll();

    public int save(UserVO vo);
}
