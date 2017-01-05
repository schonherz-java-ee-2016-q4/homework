package hu.schonherz.java.training.kovtamas.data.mapper;

import hu.schonherz.java.training.kovtamas.data.dto.UserDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<UserDto> {

    @Override
    public UserDto mapRow(ResultSet results, int rowNum) throws SQLException {
        UserDto dto = new UserDto();

        dto.setId(results.getInt("id"));
        dto.setGender(results.getString("gender"));
        dto.setFirstName(results.getString("first_name"));
        dto.setLastName(results.getString("last_name"));
        dto.setStreet(results.getString("street"));
        dto.setCity(results.getString("city"));
        dto.setPostCode(results.getInt("post_code"));
        dto.setEmail(results.getString("email"));
        dto.setUsername(results.getString("username"));
        dto.setPassword(results.getString("password"));
        dto.setDob(results.getDate("date_of_birth"));
        dto.setRegistered(results.getDate("registered"));
        dto.setPhone(results.getString("phone"));
        dto.setPicUrl(results.getString("pic_url"));

        return dto;
    }

}
