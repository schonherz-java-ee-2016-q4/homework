package hu.schonherz.blog.data.user.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.blog.data.user.dto.UserDto;

public class UserMapper implements RowMapper<UserDto> {
    @Override
    public UserDto mapRow(ResultSet rs, int arg1) throws SQLException {
        UserDto back = new UserDto();
        back.setId(rs.getInt("id"));
        back.setDob(rs.getDate("dob"));
        back.setRegistered(rs.getDate("registered"));
        back.setCell(rs.getString("cell"));
        back.setEmail(rs.getString("email"));
        back.setGender(rs.getString("gender"));
        back.setPhone(rs.getString("phone"));
        back.setRole(rs.getString("role"));
        return back;
    }
}
