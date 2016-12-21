package hu.schonherz.blog.service;

import java.util.Collection;

import hu.schonherz.blog.service.api.user.dao.UserDAO;
import hu.schonherz.blog.service.api.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import vo.UserVO;

public class UserServiceImpl implements UserService {

    private UserDAO dao = new UserDAO();
    
    @Override
    public UserDTO findByUserName(String username) throws UserNotFoundException {
        return dao.findByUserName(username);
    }

    @Override
    public Collection<UserDTO> findAll() {
        return dao.findAll();
    }

    @Override
    public int save(UserVO vo) {
      UserDTO dto = new UserDTO();
      dto.setFirstName(vo.getFirstName());
      dto.setLastName(vo.getLastName());
      dto.setUsername(vo.getUsername());
      dto.setPassword(vo.getPassword());
      dto.setEmail(vo.getEmail());
      dto.setGender(vo.getGender());
      dto.setDate_of_birth(vo.getDate_of_birth());
      dto.setLocation(vo.getLocation());
      dto.setPhone(vo.getPhone());
      dao.save(dto);
        return 0;
    }

}
