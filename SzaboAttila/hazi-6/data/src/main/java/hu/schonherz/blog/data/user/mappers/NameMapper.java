package hu.schonherz.blog.data.user.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.blog.data.user.dto.NameDto;

public class NameMapper implements RowMapper<NameDto> {
    @Override
    public NameDto mapRow(ResultSet rs, int arg1) throws SQLException {
        NameDto back = new NameDto();

        back.setFirst(rs.getString("first"));
        back.setLast(rs.getString("last"));
        back.setTitle(rs.getString("title"));
        back.setUser_id(rs.getInt("user_id"));

        return back;
    }
}
