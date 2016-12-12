package hu.schonherz.blog.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.List;

import com.google.gson.Gson;

import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.User;
import hu.schonherz.blog.service.api.user.vo.UserResult;

public class UserServiceImpl implements UserService {

	private UserResult result;
	private String databasePath;
	
	public UserServiceImpl(String appPath) {
	    databasePath = appPath + File.separator + "example.txt";
        result = init(databasePath);
	}

	@Override
	public List<User> findAllUser() {
		return result.getResults();
	}

	private UserResult init(String databasePath) {
		Gson gson = new Gson();
		ClassLoader classLoader = getClass().getClassLoader();
		
		
        File file = new File(databasePath);
        if (!file.exists()){
            try (InputStream inputStream = classLoader.getResourceAsStream("example.txt");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));) {
                Files.copy(inputStream, file.toPath());
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
        FileReader fr;
        try {
            fr = new FileReader(file);
            result = gson.fromJson(fr, UserResult.class);
            fr.close();
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
	
	public void addNewUser(User user) {
	    result.getResults().add(user);
        
	    File file = new File(databasePath);
	    try {
    	    FileWriter fw = new FileWriter(file);
    	    fw.write(new Gson().toJson(result));
    	    fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
