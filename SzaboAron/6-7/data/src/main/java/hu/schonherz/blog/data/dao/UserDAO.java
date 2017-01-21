package hu.schonherz.blog.data.dao;

import hu.schonherz.blog.data.dto.UserDTO;

public interface UserDAO extends GenericDAO<UserDTO> {
    UserDTO findUserByUsername(String username);

    void switchStatus(String username, boolean active);
}
