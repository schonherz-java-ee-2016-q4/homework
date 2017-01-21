package hu.schonherz.blog.data.mappers;

import hu.schonherz.blog.data.dto.UserDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserDTO> {

    @Override
    public UserDTO mapRow(ResultSet rs, int arg1) throws SQLException {
        UserDTO dto = new UserDTO();
        dto.setId(rs.getInt("id"));
        dto.setNameTitle(rs.getString("name_title"));
        dto.setFirstName(rs.getString("first_name"));
        dto.setLastName(rs.getString("last_name"));
        dto.setEmail(rs.getString("email"));
        dto.setCity(rs.getString("city"));
        dto.setPostcode(rs.getInt("postcode"));
        dto.setState(rs.getString("state"));
        dto.setStreet(rs.getString("street"));
        dto.setDateOfBirth(Date.valueOf(rs.getString("dateofbirth")));
        dto.setRegistered(Date.valueOf(rs.getString("registered")));
        dto.setPhone(rs.getString("phone"));
        dto.setGender(rs.getString("gender"));
        dto.setUsername(rs.getString("username"));
        dto.setPassword(rs.getString("password"));
        dto.setLargePic(rs.getString("large_pic"));
        dto.setMediumPic(rs.getString("medium_pic"));
        dto.setThumbnailPic(rs.getString("thumbnail_pic"));
        dto.setRole(rs.getString("user_role"));
        dto.setActive(rs.getBoolean("enabled"));
        return dto;
    }

}
