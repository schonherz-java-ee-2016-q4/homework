package hu.schonherz.blog.data.post;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Geri on 2017. 01. 03..
 */
public class PostMapper implements RowMapper<PostDTO> {
    @Override
    public PostDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(resultSet.getInt("id"));
        postDTO.setTitle(resultSet.getString("title"));
        postDTO.setContent(resultSet.getString("content"));
        postDTO.setPublished(resultSet.getDate("published"));
        postDTO.setAuthorID(resultSet.getInt("user_id"));
        return postDTO;
    }
}
