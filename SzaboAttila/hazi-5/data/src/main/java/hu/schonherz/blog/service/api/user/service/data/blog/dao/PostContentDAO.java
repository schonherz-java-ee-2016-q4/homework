package hu.schonherz.blog.service.api.user.service.data.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostContentDTO;
import hu.schonherz.blog.service.api.user.service.data.blog.queries.PostContentQueries;
import hu.schonherz.blog.service.api.user.service.data.datasource.DataSourceManager;

public class PostContentDAO {

    public PostContentDTO findByPostId(int id) {
        PostContentDTO back = null;

        try (Connection connection = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(PostContentQueries.QUERY_FIND_BY_POST_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                back = toDTO(resultSet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return back;
    }

    private PostContentDTO toDTO(ResultSet rs) throws SQLException {
        PostContentDTO back = new PostContentDTO();

        back.setPost_id(rs.getInt("post_id"));
        back.setText(rs.getString("text"));

        return back;
    }

    public void save(PostContentDTO dto) {
        try (Connection connection = DataSourceManager.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(PostContentQueries.QUERY_SAVE);) {

            statement.setInt(1, dto.getPost_id());
            statement.setString(2, dto.getText());

            statement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
