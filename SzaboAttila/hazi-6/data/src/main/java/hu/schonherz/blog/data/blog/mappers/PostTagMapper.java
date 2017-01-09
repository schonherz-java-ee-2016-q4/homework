package hu.schonherz.blog.data.blog.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.blog.data.blog.dto.PostTagDto;

public class PostTagMapper implements RowMapper<PostTagDto> {
    @Override
    public PostTagDto mapRow(ResultSet rs, int arg1) throws SQLException {
        PostTagDto back = new PostTagDto();

        back.setPost_id(rs.getInt("post_id"));
        back.setTag(rs.getString("tag"));
        
        return back;
    }
}
