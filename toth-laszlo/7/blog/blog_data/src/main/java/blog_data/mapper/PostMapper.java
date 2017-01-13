package blog_data.mapper;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import blog_data.dto.PostDTO;

public class PostMapper implements RowMapper<PostDTO> {

	@Override
	public PostDTO mapRow(ResultSet rs, int arg1) throws SQLException {
			PostDTO postDTO = new PostDTO();
			Array tags;
			postDTO.setId(rs.getInt("id"));
			postDTO.setUsername(rs.getString("username"));
			postDTO.setTitle(rs.getString("title"));
			postDTO.setText(rs.getString("text"));
			tags=rs.getArray("tags");
			postDTO.setTags((String[])tags.getArray());
			postDTO.setPost_date(rs.getString("post_date"));
			
		return postDTO;
	}

	
}
