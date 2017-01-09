package hu.schonherz.blog.data.mapper;

import hu.schonherz.blog.data.dto.PostDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Geri on 2016. 12. 29..
 */
public class PostMapper implements RowMapper<PostDTO> {
    @Override
    public PostDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(resultSet.getInt("id"));
        postDTO.setTitle(resultSet.getString("title"));
        postDTO.setContent(resultSet.getString("content"));
        postDTO.setPublished(resultSet.getDate("published"));
        postDTO.setAuthorID(resultSet.getInt("author_id"));
        return postDTO;
    }
}
