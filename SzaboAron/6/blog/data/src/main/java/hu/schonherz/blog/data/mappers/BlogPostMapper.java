package hu.schonherz.blog.data.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.blog.data.dto.BlogPostDTO;

public class BlogPostMapper implements RowMapper<BlogPostDTO> {

    @Override
    public BlogPostDTO mapRow(ResultSet rs, int arg1) throws SQLException {
        BlogPostDTO dto = new BlogPostDTO();
        dto.setId(rs.getInt("id"));
        dto.setPostTitle(rs.getString("post_title"));
        dto.setPostBody(rs.getString("post_body"));
        dto.setPostPublishTime(rs.getDate("post_publish_time"));
        dto.setUserId(rs.getInt("user_id"));
        return dto;
    }

}
