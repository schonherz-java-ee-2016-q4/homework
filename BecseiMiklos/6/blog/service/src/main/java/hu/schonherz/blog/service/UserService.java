package hu.schonherz.blog.service;

import hu.schonherz.blog.service.api.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;

import java.util.Collection;

public interface UserService {

    Collection<UserDTO> findAll();

    UserDTO findUserByName(String username) throws UserNotFoundException;

    public int save(UserVO vo);

}
