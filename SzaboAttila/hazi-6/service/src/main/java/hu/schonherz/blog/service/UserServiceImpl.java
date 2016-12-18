package hu.schonherz.blog.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import hu.schonherz.blog.data.user.dao.GenericDao;
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

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private GenericDao<LocationDto> locationDao;
    @Autowired
    private GenericDao<LoginDto> loginDao;
    @Autowired
    private GenericDao<NameDto> nameDao;
    @Autowired
    private GenericDao<PictureDto> pictureDao;
    
    public UserServiceImpl() {
        //if the database is empty fill it with example users
        /*if(userDao.findAll().size() == 0) {
            Gson gson = new Gson();
            ClassLoader classLoader = getClass().getClassLoader();
            try (InputStream inputStream = classLoader.getResourceAsStream("example.txt");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));) {
                UserResult result = gson.fromJson(bufferedReader, UserResult.class);
                
                for (User user : result.getResults()) {
                    UserToUserDto conv = new UserToUserDto(user);
                    userDao.save(conv.getUserDto(), conv.getLocationDto(), conv.getLoginDto(), conv.getNameDto(),
                            conv.getPictureDto());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    }

    @Override
    public List<User> findAllUser() {
        UserResult result = new UserResult();
        List<User> users = new ArrayList<>();
        for (UserDto userDto : userDao.findAll()) {
            users.add(getUserFromUserDto(userDto));
        }
        result.setResults(users);

        return result.getResults();
    }

    @Override
    public User findUserByUsername(String username) throws UserNotFoundException {
        UserDto userDto = userDao.findByUsername(username);
        
        if (userDto == null) {
            throw new UserNotFoundException();
        }
        
        return getUserFromUserDto(userDto);
    }

    @Override
    public User findByUserId(int id) {
        return getUserFromUserDto(userDao.findById(id));
    }
    
    private User getUserFromUserDto(UserDto userDto) {
        NameDto nameDto = nameDao.findById(userDto.getId());
        PictureDto pictureDto = pictureDao.findById(userDto.getId());
        LoginDto loginDto = loginDao.findById(userDto.getId());
        LocationDto locationDto = locationDao.findById(userDto.getId());
        
        UserDtoToUser conv = new UserDtoToUser(userDto, locationDto, loginDto, pictureDto, nameDto);
        return conv.getUser();
    }
    
    @Override
    public void addNewUser(User user) {
        try {
            UserToUserDto conv = new UserToUserDto(user);
            userDao.save(conv.getUserDto(), conv.getLocationDto(), conv.getLoginDto(), conv.getNameDto(),
                    conv.getPictureDto());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
