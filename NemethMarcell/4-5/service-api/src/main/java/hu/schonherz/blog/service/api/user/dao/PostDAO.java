package hu.schonherz.blog.service.api.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.postgresql.jdbc2.ArrayAssistantRegistry;

import hu.schonherz.blog.service.api.user.datasource.DataSourceManager;
import hu.schonherz.blog.service.api.user.dto.PostDTO;
import hu.schonherz.blog.service.api.user.queries.UserQueries;

public class PostDAO {

    public int save(PostDTO dto){
        try(Connection conn = DataSourceManager.getDataSource().getConnection()){
            PreparedStatement statement = conn.prepareStatement(UserQueries.QUERY_INSERT_POST);
            statement.setString(1, dto.getName());
            statement.setString(2, dto.getTitle());
            statement.setString(3, dto.getTextArea());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
        
        
    }
    
    public Collection<PostDTO> findAll(){
        List<PostDTO> posts = new ArrayList<>();
            
        try(Connection conn = DataSourceManager.getDataSource().getConnection()){
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(UserQueries.QUERY_FIND_ALL_POST);
            
            while(rs.next()){
                PostDTO postDTO = new PostDTO();
                postDTO.setName(rs.getString("name"));
                postDTO.setTitle(rs.getString("title"));
                postDTO.setDate(rs.getDate("my_date"));
                postDTO.setTextArea(rs.getString("textarea"));
                
                
                posts.add(postDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }
}
