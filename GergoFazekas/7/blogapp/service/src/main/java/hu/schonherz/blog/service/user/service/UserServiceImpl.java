package hu.schonherz.blog.service.user.service;

import hu.schonherz.blog.data.GenericDAO;
import hu.schonherz.blog.data.user.GenericUserDAO;
import hu.schonherz.blog.data.user.UserDAO;
import hu.schonherz.blog.data.user.UserDTO;
import hu.schonherz.blog.service.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Geri on 2017. 01. 04..
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private GenericUserDAO<UserDTO> userDAO;


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

    @Override
    public void changeStatus(int id) {
        userDAO.changeStatus(id);
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
        userDTO.setActive(userVO.getActive());
        userDTO.setRole(userVO.getRole());
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
        userVO.setActive(userDTO.getActive());
        userVO.setRole(userDTO.getRole());
        return userVO;
    }

}
