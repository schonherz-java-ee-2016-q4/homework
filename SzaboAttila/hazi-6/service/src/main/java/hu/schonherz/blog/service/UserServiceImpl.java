package hu.schonherz.blog.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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
import hu.schonherz.blog.service.api.user.vo.UserVo;
import hu.schonherz.blog.service.api.user.vo.UserResultVo;
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
    
    @PostConstruct
    private void init() {
        //if the database is empty fill it with example users
        if(userDao.findAll().size() == 0) {
            Gson gson = new Gson();
            ClassLoader classLoader = getClass().getClassLoader();
            try (InputStream inputStream = classLoader.getResourceAsStream("example.txt");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));) {
                UserResultVo result = gson.fromJson(bufferedReader, UserResultVo.class);
                
                for (UserVo user : result.getResults()) {
                    UserToUserDto conv = new UserToUserDto(user);
                    userDao.save(conv.getUserDto(), conv.getLocationDto(), conv.getLoginDto(), conv.getNameDto(),
                            conv.getPictureDto());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public List<UserVo> findAllUser() {
        UserResultVo result = new UserResultVo();
        List<UserVo> users = new ArrayList<>();
        for (UserDto userDto : userDao.findAll()) {
            users.add(getUserFromUserDto(userDto));
        }
        result.setResults(users);

        return result.getResults();
    }

    @Override
    public UserVo findUserByUsername(String username) throws UserNotFoundException {
        UserDto userDto = userDao.findByUsername(username);
        
        if (userDto == null) {
            throw new UserNotFoundException();
        }
        
        return getUserFromUserDto(userDto);
    }

    @Override
    public UserVo findByUserId(int id) {
        return getUserFromUserDto(userDao.findById(id));
    }
    
    private UserVo getUserFromUserDto(UserDto userDto) {
        NameDto nameDto = nameDao.findById(userDto.getId());
        PictureDto pictureDto = pictureDao.findById(userDto.getId());
        LoginDto loginDto = loginDao.findById(userDto.getId());
        LocationDto locationDto = locationDao.findById(userDto.getId());
        
        UserDtoToUser conv = new UserDtoToUser(userDto, locationDto, loginDto, pictureDto, nameDto);
        return conv.getUser();
    }
    
    @Override
    public void addNewUser(UserVo user) {
        try {
            UserToUserDto conv = new UserToUserDto(user);
            userDao.save(conv.getUserDto(), conv.getLocationDto(), conv.getLoginDto(), conv.getNameDto(),
                    conv.getPictureDto());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
