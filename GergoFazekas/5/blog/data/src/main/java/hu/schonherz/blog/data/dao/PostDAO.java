package hu.schonherz.blog.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.schonherz.blog.data.datasource.DataSourceManager;
import hu.schonherz.blog.data.dto.PostDTO;
import hu.schonherz.blog.data.queries.PostQueries;

public class PostDAO implements GenericDAO<PostDTO> {

    @Override
    public Collection<PostDTO> findAll() {
        List<PostDTO> posts = new ArrayList<>();

        try (Connection conn = DataSourceManager.getInstance().getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(PostQueries.QUERY_FROM_ALL);
            while (rs.next()) {
                posts.add(toDTO(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error while connecting with the database!");
            e.printStackTrace();
        }

        return posts;
    }

    @Override
    public PostDTO findById(int id) {
        try(Connection conn = DataSourceManager.getInstance().getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(PostQueries.QUERY_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return toDTO(rs);
                
            }
        } catch (SQLException e) {
            System.err.println("Error while connecting with the database!");
            e.printStackTrace();
        } 
        return null;
    }

    @Override
    public int save(PostDTO dto) {
        try(Connection conn = DataSourceManager.getInstance().getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(PostQueries.QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setInt(1, dto.getId());
            preparedStatement.setString(1, dto.getTitle());
            preparedStatement.setString(2, dto.getContent());
            preparedStatement.setDate(3, dto.getPublished());
            preparedStatement.setInt(4, dto.getAuthorID());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Error while connecting with the database!");
            e.printStackTrace();
        } 
        return 0;
    }
    
    private static PostDTO toDTO(ResultSet rs) throws SQLException {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(rs.getInt("id"));
        postDTO.setTitle(rs.getString("title"));
        postDTO.setContent(rs.getString("content"));
        postDTO.setPublished(rs.getDate("published"));
        postDTO.setAuthorID(rs.getInt("user_id"));
        return postDTO;
    }

}
