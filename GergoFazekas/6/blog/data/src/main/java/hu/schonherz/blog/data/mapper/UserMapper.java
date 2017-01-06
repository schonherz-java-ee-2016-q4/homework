package hu.schonherz.blog.data.mapper;

import hu.schonherz.blog.data.dto.UserDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Geri on 2016. 12. 29..
 */
public class UserMapper implements RowMapper<UserDTO> {
    @Override
    public UserDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        UserDTO userDTO = new UserDTO();
        userDTO.setCity(resultSet.getString("city"));
        userDTO.setDob(resultSet.getDate("dob"));
        userDTO.setEmail(resultSet.getString("email"));
        userDTO.setFirstName(resultSet.getString("first_name"));
        userDTO.setGender(resultSet.getString("gender"));
        userDTO.setId(resultSet.getInt("id"));
        userDTO.setLastName(resultSet.getString("last_name"));
        userDTO.setPhone(resultSet.getString("phone"));
        userDTO.setLargePicture(resultSet.getString("large_picture"));
        userDTO.setMediumPicture(resultSet.getString("medium_picture"));
        userDTO.setThumbnail(resultSet.getString("thumbnail"));
        userDTO.setPassword(resultSet.getString("password"));
        userDTO.setPostcode(resultSet.getInt("postcode"));
        userDTO.setState(resultSet.getString("state"));
        userDTO.setStreet(resultSet.getString("street"));
        userDTO.setUsername(resultSet.getString("username"));
        userDTO.setRegistered(resultSet.getDate("registered"));
        return userDTO;
    }
}

