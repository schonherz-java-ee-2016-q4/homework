package hu.schonherz.blog.service.api.user.service.data.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.schonherz.blog.service.api.user.service.data.blog.dto.PostBlogDTO;
import hu.schonherz.blog.service.api.user.service.data.blog.queries.PostBlogQueries;
import hu.schonherz.blog.service.api.user.service.data.datasource.DataSourceManager;


public class PostBlogDAO {
	public Collection<PostBlogDTO> findAll(){
        List<PostBlogDTO> posts = new ArrayList<>();
        
        try (Connection connection= DataSourceManager.getDataSource().getConnection()){
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(PostBlogQueries.QUERY_FIND_ALL);
            
            while(rs.next()){
                posts.add(toDTO(rs));
            }
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return posts;
    }
    
    public PostBlogDTO findById(int id){
        try(Connection connection = DataSourceManager.getDataSource().getConnection()){
            PreparedStatement statement = connection.prepareStatement(PostBlogQueries.QUERY_FIND_BY_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return toDTO(rs);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public int save(PostBlogDTO dto){
        try(Connection connection = DataSourceManager.getDataSource().getConnection()){
            PreparedStatement prepStatement = connection.prepareStatement(PostBlogQueries.QUERY_INSERT ,Statement.RETURN_GENERATED_KEYS);
            prepStatement.setString(1, dto.getUsername());
            prepStatement.setString(2, dto.getHeader());
            prepStatement.setString(3, dto.getContent());
            prepStatement.setDate(4, dto.getCreated());
            prepStatement.setString(5, dto.getTags().toString());
            prepStatement.executeUpdate();
            
            ResultSet rs = prepStatement.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt("id");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return 0;
    }
    
    
    private static PostBlogDTO toDTO(ResultSet rs) throws SQLException{
    	PostBlogDTO postDTO = new PostBlogDTO();
        
        postDTO.setId(rs.getInt("id"));
        postDTO.setHeader(rs.getString("title"));
        postDTO.setContent(rs.getString("content"));
        postDTO.setUsername(rs.getString("username"));
        postDTO.setCreated(rs.getDate("created"));
        postDTO.setTags(rs.getString("tags"));

        return postDTO;
    }

}
