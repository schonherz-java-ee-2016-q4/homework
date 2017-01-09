package hu.schonherz.blog.service.api.user.rowmapper;

import hu.schonherz.blog.service.api.user.dto.PostDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Marci on 2016. 12. 27..
 */
public class PostMapper implements RowMapper<PostDTO> {

    @Override
    public PostDTO mapRow(ResultSet rs, int i) throws SQLException {
        PostDTO postDTO = new PostDTO();
        postDTO.setName(rs.getString("name"));
        postDTO.setTitle(rs.getString("title"));
        postDTO.setDate(rs.getDate("my_date"));
        postDTO.setTextArea(rs.getString("textarea"));

        return postDTO;

    }
}
