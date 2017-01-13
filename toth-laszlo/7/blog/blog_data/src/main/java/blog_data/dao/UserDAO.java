package blog_data.dao;

import java.util.Collection;

import org.springframework.stereotype.Component;

import blog_data.dto.UserDTO;
@Component
public interface UserDAO {
	public UserDTO findbyUsername(String username);
	public Collection<UserDTO> findAll();
	public int register(UserDTO user);

}
