package hu.schonherz.blog.data.blog.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.blog.data.blog.dto.PostDto;

public class PostMapper implements RowMapper<PostDto> {
    @Override
    public PostDto mapRow(ResultSet rs, int arg1) throws SQLException {
        PostDto back = new PostDto();

        back.setId(rs.getInt("id"));
        back.setPosted(rs.getTimestamp("posted"));
        back.setTitle(rs.getString("title"));
        back.setUser_id(rs.getInt("user_id"));
        
        try {
            back.setContent(rs.getString("content"));
        }
        catch (Exception e) {
            back.setContent("");
        }

        return back;
    }
}
