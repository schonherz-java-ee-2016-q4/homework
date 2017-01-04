package hu.schonherz.blog.data.user.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.blog.data.user.dto.LoginDto;

public class LoginMapper implements RowMapper<LoginDto> {
    @Override
    public LoginDto mapRow(ResultSet rs, int arg1) throws SQLException {
        LoginDto back = new LoginDto();

        back.setPassword(rs.getString("password"));
        back.setUser_id(rs.getInt("user_id"));
        back.setUsername(rs.getString("username"));

        return back;
    }
}
