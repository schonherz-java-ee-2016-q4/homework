package hu.schonherz.blog.service.api.user.rowmapper;

import hu.schonherz.blog.service.api.user.dto.UserDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Marci on 2016. 12. 27..
 */
public class UserMapper implements RowMapper<UserDTO> {


    @Override
    public UserDTO mapRow(ResultSet rs, int i) throws SQLException {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(rs.getInt("id"));
        userDTO.setFirstName(rs.getString("first_name"));
        userDTO.setLastName(rs.getString("last_name"));
        userDTO.setUsername(rs.getString("username"));
        userDTO.setPassword(rs.getString("password"));
        userDTO.setEmail(rs.getString("email"));
        userDTO.setGender(rs.getString("gender"));
        userDTO.setDate_of_birth(rs.getString("date_of_birth"));
        userDTO.setLocation(rs.getString("location"));
        userDTO.setPhone(rs.getString("phone"));
        userDTO.setImg(rs.getString("img"));

        return userDTO;
    }
}
