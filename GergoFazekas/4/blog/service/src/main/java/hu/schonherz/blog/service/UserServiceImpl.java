package hu.schonherz.blog.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.google.gson.Gson;

import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.User;
import hu.schonherz.blog.service.api.user.vo.UserResult;

public class UserServiceImpl implements UserService {

    private UserResult result;

    
    public UserServiceImpl() {
        result = init();
    }

    @Override
    public List<User> findAllUser() {
        return result.getResults();
    }

    private UserResult init() {
        Gson gson = new Gson();
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("example.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));) {

            result = gson.fromJson(bufferedReader, UserResult.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param name
     * @return
     */
    public User findUserByName(String name) throws UserNotFoundException {
    
        List<User> users = result.getResults();
        for (User user : users) {
            if (user.getLogin().getUsername().equals(name)) {
                return user;
            }
        }
        throw new UserNotFoundException();

    }
    
    public void addUser(User user) {
        result = init();
        result.getResults().add(user);
        Gson gson = new Gson();
        String json = gson.toJson(result);
        try (FileWriter fw = new FileWriter(new File("example.txt"), false)) {
            fw.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
