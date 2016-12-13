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
import hu.schonherz.blog.service.api.user.service.data.user.dao.NameDAO;
import hu.schonherz.blog.service.api.user.service.data.user.dao.PictureDAO;
import hu.schonherz.blog.service.api.user.service.data.user.dao.UserDAO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.LocationDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.LoginDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.NameDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.PictureDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.vo.User;
import hu.schonherz.blog.service.api.user.vo.UserResult;
import hu.schonherz.blog.service.user.convert.UserDTOToUser;
import hu.schonherz.blog.service.user.convert.UserToUserDTO;

public class UserServiceImpl implements UserService {

    private UserDAO user_dao;

    public UserServiceImpl() {
        user_dao = new UserDAO();
        init();
    }

    @Override
    public List<User> findAllUser() {
        UserResult result = new UserResult();
        List<User> users = new ArrayList<>();
        for (UserDTO userDTO : user_dao.findAll()) {
            NameDTO nameDTO = new NameDAO().findById(userDTO.getId());
            PictureDTO pictureDTO = new PictureDAO().findById(userDTO.getId());
            LoginDTO loginDTO = new LoginDAO().findById(userDTO.getId());
            LocationDTO locationDTO = new LocationDAO().findById(userDTO.getId());;
            
            UserDTOToUser conv = new UserDTOToUser(userDTO, locationDTO, loginDTO, pictureDTO, nameDTO);
            users.add(conv.getUser());
        }
        
        result.setResults(users);

        return result.getResults();
    }

    private void init() {
        //if the database is empty fill it with example users
        if(user_dao.findAll().size() == 0) {
            Gson gson = new Gson();
            ClassLoader classLoader = getClass().getClassLoader();
            try (InputStream inputStream = classLoader.getResourceAsStream("example.txt");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));) {
                UserResult result = gson.fromJson(bufferedReader, UserResult.class);
                
                for (User user : result.getResults()) {
                    UserToUserDTO conv = new UserToUserDTO(user);
                    user_dao.save(conv.getUserDTO(), conv.getLocationDTO(), conv.getLoginDTO(), conv.getNameDTO(),
                            conv.getPictureDTO());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param name
     * @return
     */
    public User findUserByName(String name) throws UserNotFoundException {
        UserDTO userDTO = user_dao.findByUsername(name);
        
        if (userDTO == null) {
            throw new UserNotFoundException();
        }
        
        NameDTO nameDTO = new NameDAO().findById(userDTO.getId());
        PictureDTO pictureDTO = new PictureDAO().findById(userDTO.getId());
        LoginDTO loginDTO = new LoginDAO().findById(userDTO.getId());
        LocationDTO locationDTO = new LocationDAO().findById(userDTO.getId());;
        
        UserDTOToUser conv = new UserDTOToUser(userDTO, locationDTO, loginDTO, pictureDTO, nameDTO);
        return conv.getUser();
    }

    public User findByUserId(int id) {
        UserDTO userDTO = new UserDAO().findById(id);
        NameDTO nameDTO = new NameDAO().findById(userDTO.getId());
        PictureDTO pictureDTO = new PictureDAO().findById(userDTO.getId());
        LoginDTO loginDTO = new LoginDAO().findById(userDTO.getId());
        LocationDTO locationDTO = new LocationDAO().findById(userDTO.getId());;
        
        UserDTOToUser conv = new UserDTOToUser(userDTO, locationDTO, loginDTO, pictureDTO, nameDTO);
        return conv.getUser();
    }
    
    public void addNewUser(User user) {
        try {
            UserToUserDTO conv = new UserToUserDTO(user);
            user_dao.save(conv.getUserDTO(), conv.getLocationDTO(), conv.getLoginDTO(), conv.getNameDTO(),
                    conv.getPictureDTO());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
