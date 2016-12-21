package hu.schonherz.blog.data.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.schonherz.blog.data.dao.querys.BlogPostQuerys;
import hu.schonherz.blog.data.datasource.DataSourceManager;
import hu.schonherz.blog.data.dto.BlogPostDTO;

public class BlogPostDAOImpl implements GenericDAO<BlogPostDTO> {

    @Override
    public Collection<BlogPostDTO> findAll() {
        List<BlogPostDTO> posts = new ArrayList<>();

        try (Connection conn = DataSourceManager.getDataSource().getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(BlogPostQuerys.QUERY_FIND_ALL);
            while (rs.next()) {
                posts.add(toDTO(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return posts;
    }

    @Override
    public BlogPostDTO findById(int id) {
        try (Connection conn = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement prepStatement = conn.prepareStatement(BlogPostQuerys.QUERY_FIND_BY_ID);
            prepStatement.setInt(1, id);
            ResultSet rs = prepStatement.executeQuery();
            if (rs.next()) {
                return toDTO(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int save(BlogPostDTO dto) {
        try (Connection conn = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement prepStatement = conn.prepareStatement(BlogPostQuerys.QUERY_INSERT,
                    Statement.RETURN_GENERATED_KEYS);

            prepStatement.setString(1, dto.getPostTitle());
            prepStatement.setString(2, dto.getPostBody());
            prepStatement.setDate(3, dto.getPostPublishTime());
            prepStatement.setInt(4, dto.getUserId());
            prepStatement.executeUpdate();

            ResultSet rs = prepStatement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    private static BlogPostDTO toDTO(ResultSet rs) throws SQLException {
        BlogPostDTO post = new BlogPostDTO();
        post.setId(rs.getInt("id"));
        post.setPostTitle(rs.getString("post_title"));
        post.setPostBody(rs.getString("post_body"));
        post.setPostPublishTime(Date.valueOf(rs.getString("post_publish_time")));
        post.setUserId(rs.getInt("id"));
        return post;
    }

}
