package homework5_data.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import homework5_data.dto.PostDTO;
import homework5_data.queries.PostQueries;
import homework5_data.source.DataSourceManager;

public class PostDAO {
    public Collection<PostDTO> findAll(){
        List<PostDTO> posts = new ArrayList<>();
        
        try (Connection conn= DataSourceManager.getDataSource().getConnection()){
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(PostQueries.QUERY_FIND_ALL);
            
            while(rs.next()){
                posts.add(toDTO(rs));
            }
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return posts;
    }
    
    public PostDTO findById(int id){
        try(Connection conn = DataSourceManager.getDataSource().getConnection()){
            PreparedStatement statement = conn.prepareStatement(PostQueries.QUERY_FIND_BY_ID);
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
    
    public int save(PostDTO DTO){
        try(Connection conn = DataSourceManager.getDataSource().getConnection()){
            Array tags;
            PreparedStatement prepStatement = conn.prepareStatement(PostQueries.QUERY_INSERT ,Statement.RETURN_GENERATED_KEYS);
            tags=conn.createArrayOf("text", DTO.getTags());
            conn.createArrayOf("text", DTO.getTags());
            prepStatement.setString(1, DTO.getHeader());
            prepStatement.setString(2, DTO.getText());
            prepStatement.setString(3, DTO.getUsername());
            prepStatement.setString(4, DTO.getDate());
            prepStatement.setArray(5, tags);
            
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
    
    
    private static PostDTO toDTO(ResultSet rs) throws SQLException{
        PostDTO postDTO = new PostDTO();
        Array tags;
        tags=rs.getArray("tags");
        postDTO.setId(rs.getInt("id"));
        postDTO.setHeader(rs.getString("header"));
        postDTO.setText(rs.getString("text"));
        postDTO.setUsername(rs.getString("username"));
        postDTO.setDate(rs.getString("date"));
        
        postDTO.setTags((String[])tags.getArray());

        
        
        return postDTO;
    }
}
