package hu.schonherz.blog.service.userservice;

import java.util.ArrayList;
import java.util.List;

import hu.schonherz.blog.data.dao.UserDAO;
import hu.schonherz.blog.data.dao.UserDAOImpl;
import hu.schonherz.blog.data.dto.UserDTO;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.UserVO;

public class UserServiceImpl implements UserService {

    private UserDAO dao;

    public UserServiceImpl() {
        dao = new UserDAOImpl();
    }

    @Override
    public List<UserVO> findAllUser() {
        List<UserVO> userList = new ArrayList<>();
        for (UserDTO dto : dao.findAll()) {
            userList.add(toVo(dto));
        }
        return userList;
    }

    @Override
    public UserVO findUserByName(String name) throws UserNotFoundException {
        UserDTO userdto = dao.findUserByUsername(name);
        UserVO user = toVo(userdto);
        return user;
    }

    @Override
    public void saveUser(UserVO user) {
        dao.save(toDTO(user));

    }

    private static UserVO toVo(UserDTO dto) {
        UserVO user = new UserVO();
        user.setCity(dto.getCity());
        user.setDateOfBirth(dto.getDateOfBirth());
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setGender(dto.getGender());
        user.setId(dto.getId());
        user.setLargePic(dto.getLargePic());
        user.setLastName(dto.getLastName());
        user.setMediumPic(dto.getMediumPic());
        user.setNameTitle(dto.getNameTitle());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());
        user.setPostcode(dto.getPostcode());
        user.setRegistered(dto.getRegistered());
        user.setState(dto.getState());
        user.setStreet(dto.getStreet());
        user.setThumbnailPic(dto.getThumbnailPic());
        user.setUsername(dto.getUsername());
        return user;
    }

    private static UserDTO toDTO(UserVO vo) {
        UserDTO user = new UserDTO();
        user.setCity(vo.getCity());
        user.setDateOfBirth(vo.getDateOfBirth());
        user.setEmail(vo.getEmail());
        user.setFirstName(vo.getFirstName());
        user.setGender(vo.getGender());
        user.setId(vo.getId());
        user.setLargePic(vo.getLargePic());
        user.setLastName(vo.getLastName());
        user.setMediumPic(vo.getMediumPic());
        user.setNameTitle(vo.getNameTitle());
        user.setPassword(vo.getPassword());
        user.setPhone(vo.getPhone());
        user.setPostcode(vo.getPostcode());
        user.setRegistered(vo.getRegistered());
        user.setState(vo.getState());
        user.setStreet(vo.getStreet());
        user.setThumbnailPic(vo.getThumbnailPic());
        user.setUsername(vo.getUsername());
        return user;
    }

}
