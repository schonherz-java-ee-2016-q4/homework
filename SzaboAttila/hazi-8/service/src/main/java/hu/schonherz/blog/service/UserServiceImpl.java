package hu.schonherz.blog.service;

import com.google.gson.Gson;
import hu.schonherz.blog.data.domain.UserEntity;
import hu.schonherz.blog.data.repository.UserRepository;
import hu.schonherz.blog.service.api.service.UserService;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.vo.UserResultVo;
import hu.schonherz.blog.service.api.user.vo.UserVo;
import hu.schonherz.blog.service.converter.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;
    
    @PostConstruct
    private void init() {
        //if the database is empty fill it with example users
        if(userRepository.count() == 0) {
            Gson gson = new Gson();
            ClassLoader classLoader = getClass().getClassLoader();
            try (InputStream inputStream = classLoader.getResourceAsStream("example.txt");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));) {
                UserResultVo result = gson.fromJson(bufferedReader, UserResultVo.class);
                
                for (UserVo user : result.getResults()) {
                    addNewUser(user);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public List<UserVo> findAllUser() {
        return UserConverter.toVO(userRepository.findAll());
    }

    @Override
    public UserVo findUserByUsername(String username) throws UserNotFoundException {
        UserEntity foundUser = userRepository.findByUsername(username);
        if (foundUser == null)
            throw new UserNotFoundException();

        return UserConverter.toVO(foundUser);
    }
    
    @Override
    public UserVo findByUserId(int id) {
        return UserConverter.toVO(userRepository.findOne(id));
    }
    
    @Override
    public void addNewUser(UserVo user) {
        try {
            UserEntity entity = UserConverter.toEntity(user);
            entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
            entity.setActive(true);
            entity.setRole("user");
            userRepository.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean switchUserStatus(String username) {
        UserEntity user = userRepository.findByUsername(username);
    	user.setActive(!user.isActive());
        userRepository.save(user);
    	
    	return user.isActive();
    }
}
