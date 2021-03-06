package hu.schonherz.blog.service.api.user.mapper;

import hu.schonherz.blog.service.api.user.dto.UserDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserMapper implements RowMapper<UserDTO> {

    @Override
    public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        UserDTO user = new UserDTO();
        user.setId(rs.getInt("id"));
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setGender(rs.getString("gender"));
        user.setDate_of_birth(rs.getString("date_of_birth"));
        user.setLocation(rs.getString("location"));
        user.setPhone(rs.getString("phone"));
        user.setImg(rs.getString("img"));

        return user;
    }
}
