package blog_data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import blog_data.dto.UserDTO;

@Repository
public class UserMapper implements RowMapper<UserDTO>{
	
	public UserDTO mapRow(ResultSet rs, int arg1) throws SQLException {
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(rs.getString("username"));
		userDTO.setPassword(rs.getString("password"));
		userDTO.setBirth_date(rs.getString("birth_date"));
		userDTO.setEmail(rs.getString("email"));
		userDTO.setRegistration_date(rs.getString("registration_date"));
		userDTO.setPicture(rs.getString("picture"));
		return userDTO;
	}

}
