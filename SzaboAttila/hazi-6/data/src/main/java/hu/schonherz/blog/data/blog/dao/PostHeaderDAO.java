package hu.schonherz.blog.data.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.schonherz.blog.blog.queries.PostHeadersQueries;
import hu.schonherz.blog.data.blog.dto.PostHeaderDTO;
import hu.schonherz.blog.data.blog.dto.PostTagDTO;
import hu.schonherz.blog.data.datasource.DataSourceManager;

public class PostHeaderDAO {

    public Collection<PostHeaderDTO> findAllHeaders() {
        List<PostHeaderDTO> back = new ArrayList<>();

        try (Connection connection = DataSourceManager.getDataSource().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(PostHeadersQueries.QUERY_FIND_ALL_HEADERS);

            while (resultSet.next()) {
                back.add(toDTO(resultSet, false));
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
                back = toDTO(resultSet, true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return back;
    }

    private PostHeaderDTO toDTO(ResultSet rs, boolean useContent) throws SQLException {
        PostHeaderDTO back = new PostHeaderDTO();

        back.setId(rs.getInt("id"));
        back.setPosted(rs.getTimestamp("posted"));
        back.setTitle(rs.getString("title"));
        back.setUser_id(rs.getInt("user_id"));
        if (useContent) {
            back.setContent(rs.getString("content"));
        }
        else {
            back.setContent("");
        }

        return back;
    }

    public int save(PostHeaderDTO headerDTO, List<PostTagDTO> postTagDTO) {
        try (Connection connection = DataSourceManager.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(PostHeadersQueries.QUERY_SAVE,
                        Statement.RETURN_GENERATED_KEYS);) {

            statement.setInt(1, headerDTO.getUser_id());
            statement.setString(2, headerDTO.getTitle());
            statement.setTimestamp(3, headerDTO.getPosted());
            statement.setString(4, headerDTO.getContent());

            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                headerDTO.setId(generatedKeys.getInt(1));
                
                for (PostTagDTO tag : postTagDTO) {
                    tag.setPost_id(headerDTO.getId());
                }
                
                new PostTagDAO().saveAll(postTagDTO);
                return headerDTO.getId();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
