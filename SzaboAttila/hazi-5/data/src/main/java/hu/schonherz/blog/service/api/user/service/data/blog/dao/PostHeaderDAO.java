package hu.schonherz.blog.service.api.user.service.data.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostContentDTO;
import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostHeaderDTO;
import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostTagDTO;
import hu.schonherz.blog.service.api.user.service.data.blog.queries.PostHeadersQueries;
import hu.schonherz.blog.service.api.user.service.data.datasource.DataSourceManager;

public class PostHeaderDAO {

    public Collection<PostHeaderDTO> findAll() {
        List<PostHeaderDTO> back = new ArrayList<>();

        try (Connection connection = DataSourceManager.getDataSource().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(PostHeadersQueries.QUERY_FIND_ALL);

            while (resultSet.next()) {
                back.add(toDTO(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return back;
    }
    
    public PostHeaderDTO findByPostId(int id) {
        PostHeaderDTO back = null;

        try (Connection connection = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(PostHeadersQueries.QUERY_FIND_BY_POST_ID);
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

    private PostHeaderDTO toDTO(ResultSet rs) throws SQLException {
        PostHeaderDTO back = new PostHeaderDTO();

        back.setId(rs.getInt("id"));
        back.setPosted(rs.getDate("posted"));
        back.setTitle(rs.getString("title"));
        back.setUser_id(rs.getInt("user_id"));

        return back;
    }

    public void save(PostHeaderDTO header_dto, PostContentDTO content_dto, List<PostTagDTO> postTag_dto ) {
        try (Connection connection = DataSourceManager.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(PostHeadersQueries.QUERY_SAVE,
                        Statement.RETURN_GENERATED_KEYS);) {

            statement.setInt(1, header_dto.getUser_id());
            statement.setString(2, header_dto.getTitle());
            statement.setDate(3, header_dto.getPosted());

            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                header_dto.setId(generatedKeys.getInt(1));
                
                content_dto.setPost_id(header_dto.getId());
                for (PostTagDTO tag : postTag_dto) {
                    tag.setPost_id(header_dto.getId());
                }
                
                
                new PostContentDAO().save(content_dto);
                new PostTagDAO().saveAll(postTag_dto);                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
