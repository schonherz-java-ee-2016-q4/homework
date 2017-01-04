package hu.schonherz.blog.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import hu.schonherz.blog.service.api.service.UserService;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.service.data.user.dao.LocationDAO;
import hu.schonherz.blog.service.api.user.service.data.user.dao.LoginDAO;
import hu.schonherz.blog.service.api.user.service.data.user.dao.ContactDAO;
import hu.schonherz.blog.service.api.user.service.data.user.dao.ImageDAO;
import hu.schonherz.blog.service.api.user.service.data.user.dao.UserDAO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.LocationDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.LoginDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.ContactDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.ImageDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.vo.User;
import hu.schonherz.blog.service.api.user.vo.UserResult;
import hu.schonherz.blog.service.user.convert.DTOsToUser;
import hu.schonherz.blog.service.user.convert.UserToDTOs;

public class UserServiceImpl implements UserService {

    private UserDAO userdao;

    public UserServiceImpl() {
        userdao = new UserDAO();
    }

    @Override
    public List<User> findAllUser() {
        UserResult result = new UserResult();
        List<User> users = new ArrayList<>();
        for (UserDTO userDTO : userdao.findAll()) {
            ContactDTO nameDTO = new ContactDAO().findById(userDTO.getId());
            ImageDTO pictureDTO = new ImageDAO().findById(userDTO.getId());
            LoginDTO loginDTO = new LoginDAO().findById(userDTO.getId());
            LocationDTO locationDTO = new LocationDAO().findById(userDTO.getId());;
            
            DTOsToUser conv = new DTOsToUser(userDTO, locationDTO, loginDTO, pictureDTO, nameDTO);
            users.add(conv.getUser());
        }
        
        result.setResults(users);

        return result.getResults();
    }


    public User findUserByName(String name) throws UserNotFoundException {
        UserDTO userDTO = userdao.findByUsername(name);
        
        if (userDTO == null) {
            throw new UserNotFoundException();
        }
        
        ContactDTO contactDTO = new ContactDAO().findById(userDTO.getId());
        ImageDTO imageDTO = new ImageDAO().findById(userDTO.getId());
        LoginDTO loginDTO = new LoginDAO().findById(userDTO.getId());
        LocationDTO locationDTO = new LocationDAO().findById(userDTO.getId());;
        
        DTOsToUser converter = new DTOsToUser(userDTO, locationDTO, loginDTO, imageDTO, contactDTO);
        return converter.getUser();
    }

    public User findByUserId(int id) {
        UserDTO userDTO = new UserDAO().findById(id);
        ContactDTO contactDTO = new ContactDAO().findById(userDTO.getId());
        ImageDTO imageDTO = new ImageDAO().findById(userDTO.getId());
        LoginDTO loginDTO = new LoginDAO().findById(userDTO.getId());
        LocationDTO locationDTO = new LocationDAO().findById(userDTO.getId());;
        
        DTOsToUser converter = new DTOsToUser(userDTO, locationDTO, loginDTO, imageDTO, contactDTO);
        return converter.getUser();
    }
    
    public void addNewUser(User user) {
        try {
            UserToDTOs converter = new UserToDTOs(user);
            userdao.save(converter.getUserDTO(), converter.getLocationDTO(), converter.getLoginDTO(), converter.getContactDTO(),
                    converter.getImageDTO());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
