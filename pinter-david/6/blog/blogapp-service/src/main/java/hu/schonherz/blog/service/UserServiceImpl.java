package hu.schonherz.blog.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import com.google.gson.Gson;
import hu.schonherz.blog.data.dao.GenericDAO;
import hu.schonherz.blog.data.dto.UserDTO;

import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.User;
import hu.schonherz.blog.service.api.user.vo.UserResult;
import hu.schonherz.blog.service.api.user.vo.UserVO;
import hu.schonherz.blog.service.modelmapper.ModelMapperTypes;
import java.util.Collection;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private GenericDAO<UserDTO> userDAO;
    
    @Autowired
    private ModelMapper modelMapper;
    
    
    
    private UserResult result;

    public UserServiceImpl() {
        result = init();
    }

    @Override
    public List<UserVO> findAllUser() {
        Collection<UserDTO> userDTOList = userDAO.findAll();
        return modelMapper.map(userDTOList, ModelMapperTypes.USER_VO_COLLECTION_TYPE);
    }

    private UserResult init() {
        Gson gson = new Gson();
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("example.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));) {

            result = gson.fromJson(bufferedReader, UserResult.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param name
     * @return
     * @throws hu.schonherz.blog.service.api.user.exception.UserNotFoundException
     */
    @Override
    public User findUserByName(String name) throws UserNotFoundException {

        List<User> users = result.getResults();
        for (User user : users) {
            if (user.getLogin().getUsername().equals(name)) {
                return user;
            }
        }
        throw new UserNotFoundException();

    }
}
