package hu.schonherz.java.training.kovtamas.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.google.gson.Gson;
import hu.schonherz.java.training.kovtamas.serviceapi.user.exception.UserAlreadyExistsException;

import hu.schonherz.java.training.kovtamas.serviceapi.user.exception.UserNotFoundException;
import hu.schonherz.java.training.kovtamas.serviceapi.user.service.UserService;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.Id;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.User;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.UserResult;
import java.util.Optional;

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
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));) {

            result = gson.fromJson(bufferedReader, UserResult.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public User findUserByName(String name) throws UserNotFoundException {

        List<User> users = result.getResults();
        for (User user : users) {
            if (user.getLogin().getUsername().equals(name)) {
                return user;
            }
        }
        throw new UserNotFoundException();
    }

    @Override
    public void addUser(User user) {
        if (!isUniqueUser(user)) {
            throw new UserAlreadyExistsException();
        }

        result.getResults().add(user);
    }

    private boolean isUniqueUser(User user) {
        Id id = user.getId();
        if (id == null) {
            throw new IllegalArgumentException("User ID must not be null!");
        }

        Optional<User> duplicate = result.getResults()
                .stream()
                .filter(usr -> id.equals(usr.getId()))
                .findAny();
        return !duplicate.isPresent();
    }

}
