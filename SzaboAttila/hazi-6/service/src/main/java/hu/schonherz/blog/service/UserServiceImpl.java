package hu.schonherz.blog.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import hu.schonherz.blog.data.user.dao.LocationDao;
import hu.schonherz.blog.data.user.dao.LoginDao;
import hu.schonherz.blog.data.user.dao.NameDao;
import hu.schonherz.blog.data.user.dao.PictureDao;
import hu.schonherz.blog.data.user.dao.UserDao;
import hu.schonherz.blog.data.user.dto.LocationDto;
import hu.schonherz.blog.data.user.dto.LoginDto;
import hu.schonherz.blog.data.user.dto.NameDto;
import hu.schonherz.blog.data.user.dto.PictureDto;
import hu.schonherz.blog.data.user.dto.UserDto;
import hu.schonherz.blog.service.api.service.UserService;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.vo.User;
import hu.schonherz.blog.service.api.user.vo.UserResult;
import hu.schonherz.blog.service.user.convert.UserDtoToUser;
import hu.schonherz.blog.service.user.convert.UserToUserDto;

public class UserServiceImpl implements UserService {

    private UserDao user_dao;

    public UserServiceImpl() {
        user_dao = new UserDao();
        init();
    }

    @Override
    public List<User> findAllUser() {
        UserResult result = new UserResult();
        List<User> users = new ArrayList<>();
        for (UserDto userDTO : user_dao.findAll()) {
            NameDto nameDTO = new NameDao().findById(userDTO.getId());
            PictureDto pictureDTO = new PictureDao().findById(userDTO.getId());
            LoginDto loginDTO = new LoginDao().findById(userDTO.getId());
            LocationDto locationDTO = new LocationDao().findById(userDTO.getId());;
            
            UserDtoToUser conv = new UserDtoToUser(userDTO, locationDTO, loginDTO, pictureDTO, nameDTO);
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
                    UserToUserDto conv = new UserToUserDto(user);
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
        UserDto userDTO = user_dao.findByUsername(name);
        
        if (userDTO == null) {
            throw new UserNotFoundException();
        }
        
        NameDto nameDTO = new NameDao().findById(userDTO.getId());
        PictureDto pictureDTO = new PictureDao().findById(userDTO.getId());
        LoginDto loginDTO = new LoginDao().findById(userDTO.getId());
        LocationDto locationDTO = new LocationDao().findById(userDTO.getId());;
        
        UserDtoToUser conv = new UserDtoToUser(userDTO, locationDTO, loginDTO, pictureDTO, nameDTO);
        return conv.getUser();
    }

    public User findByUserId(int id) {
        UserDto userDTO = new UserDao().findById(id);
        NameDto nameDTO = new NameDao().findById(userDTO.getId());
        PictureDto pictureDTO = new PictureDao().findById(userDTO.getId());
        LoginDto loginDTO = new LoginDao().findById(userDTO.getId());
        LocationDto locationDTO = new LocationDao().findById(userDTO.getId());;
        
        UserDtoToUser conv = new UserDtoToUser(userDTO, locationDTO, loginDTO, pictureDTO, nameDTO);
        return conv.getUser();
    }
    
    public void addNewUser(User user) {
        try {
            UserToUserDto conv = new UserToUserDto(user);
            user_dao.save(conv.getUserDTO(), conv.getLocationDTO(), conv.getLoginDTO(), conv.getNameDTO(),
                    conv.getPictureDTO());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
