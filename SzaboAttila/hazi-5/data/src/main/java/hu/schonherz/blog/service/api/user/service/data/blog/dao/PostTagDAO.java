package hu.schonherz.blog.service.api.user.service.data.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostTagDTO;
import hu.schonherz.blog.service.api.user.service.data.blog.queries.PostTagQueries;
import hu.schonherz.blog.service.api.user.service.data.datasource.DataSourceManager;

public class PostTagDAO {

    public List<PostTagDTO> findByPostId(int id) {
        List<PostTagDTO> back = new ArrayList<>();

        try (Connection connection = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(PostTagQueries.QUERY_FIND_BY_POST_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                back.add(toDTO(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return back;
    }

    private PostTagDTO toDTO(ResultSet rs) throws SQLException {
        PostTagDTO back = new PostTagDTO();

        back.setPost_id(rs.getInt("post_id"));
        back.setTag(rs.getString("tag"));
        
        return back;
    }

    public void saveAll(List<PostTagDTO> dtos) {
        for (PostTagDTO dto : dtos) {
            save(dto);
        }
    }
    
    public void save(PostTagDTO dto) {
        try (Connection connection = DataSourceManager.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(PostTagQueries.QUERY_SAVE);) {

            statement.setInt(1, dto.getPost_id());
            statement.setString(2, dto.getTag());

            statement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
