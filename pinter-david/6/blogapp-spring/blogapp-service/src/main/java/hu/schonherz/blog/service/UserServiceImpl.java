/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonherz.blog.service;

import hu.schonherz.blog.data.dao.GenericDAO;
import hu.schonherz.blog.data.dto.UserDTO;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.UserVO;
import hu.schonherz.blog.service.modelmapper.ModelMapperTypes;
import java.util.Collection;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pintyo
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private GenericDAO<UserDTO> userDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserVO> findAllUser() {
        Collection<UserDTO> userDTOList = userDAO.findAll();
        return modelMapper.map(userDTOList, ModelMapperTypes.USER_VO_COLLECTION_TYPE);

    }

    @Override
    public UserVO findUserByName(String name) throws UserNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
