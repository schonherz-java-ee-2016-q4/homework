package hu.schonherz.blog.service;

import java.util.ArrayList;
import java.util.List;

import hu.schonherz.blog.data.dao.GenericDAO;
import hu.schonherz.blog.data.dao.UserDAO;
import hu.schonherz.blog.data.dto.UserDTO;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.UserVO;

public class UserServiceImpl implements UserService {
    
    private GenericDAO<UserDTO> userDAO = new UserDAO();
    
    
    @Override
    public List<UserVO> findAll() {
        List<UserVO> users = new ArrayList<>();
        for (UserDTO userDTO : userDAO.findAll()) {
            users.add(toVO(userDTO));
        }
        return users;
    }
    
    @Override
    public UserVO findByUsername(String name) throws UserNotFoundException {
        List<UserVO> users = findAll();
        for (UserVO userVO : users) {
            if (userVO.getUsername().equals(name)) {
                return userVO;
            }
        }
        throw new UserNotFoundException();
    }

    @Override
    public void add(UserVO userVO) {
        userDAO.save(toDTO(userVO));
    }
    
    private static UserDTO toDTO (UserVO userVO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userVO.getId());
        userDTO.setFirstName(userVO.getFirstName());
        userDTO.setLastName(userVO.getLastName());
        userDTO.setEmail(userVO.getEmail());
        userDTO.setUsername(userVO.getUsername());
        userDTO.setPassword(userVO.getPassword());
        userDTO.setPhone(userVO.getPhone());
        userDTO.setGender(userVO.getGender());
        userDTO.setDob(userVO.getDob());
        userDTO.setRegistered(userVO.getRegistered());
        userDTO.setPostcode(userVO.getPostcode());
        userDTO.setStreet(userVO.getStreet());
        userDTO.setState(userVO.getState());
        userDTO.setCity(userVO.getCity());
        userDTO.setLargePicture(userVO.getLargePicture());
        userDTO.setMediumPicture(userVO.getMediumPicture());
        userDTO.setThumbnail(userVO.getThumbnail());
        return userDTO;
    }
    
    private static UserVO toVO (UserDTO userDTO) {
        UserVO userVO = new UserVO();
        userVO.setId(userDTO.getId());
        userVO.setFirstName(userDTO.getFirstName());
        userVO.setLastName(userDTO.getLastName());
        userVO.setEmail(userDTO.getEmail());
        userVO.setUsername(userDTO.getUsername());
        userVO.setPassword(userDTO.getPassword());
        userVO.setPhone(userDTO.getPhone());
        userVO.setGender(userDTO.getGender());
        userVO.setDob(userDTO.getDob());
        userVO.setRegistered(userDTO.getRegistered());
        userVO.setPostcode(userDTO.getPostcode());
        userVO.setStreet(userDTO.getStreet());
        userVO.setState(userDTO.getState());
        userVO.setCity(userDTO.getCity());
        userVO.setLargePicture(userDTO.getLargePicture());
        userVO.setMediumPicture(userDTO.getMediumPicture());
        userVO.setThumbnail(userDTO.getThumbnail());
        return userVO;
    }

}
