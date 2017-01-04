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
            userList.add(UserVO.toVO(dto));
        }
        return userList;
    }

    @Override
    public UserVO findUserByName(String name) throws UserNotFoundException {
        UserDTO userdto = dao.findUserByUsername(name);
        UserVO user = UserVO.toVO(userdto);
        return user;
    }

    @Override
    public void saveUser(UserVO user) {
        dao.save(UserVO.toDTO(user));

    }

    @Override
    public UserVO findUserById(int id) {
        return UserVO.toVO(dao.findById(id));
    }

}
