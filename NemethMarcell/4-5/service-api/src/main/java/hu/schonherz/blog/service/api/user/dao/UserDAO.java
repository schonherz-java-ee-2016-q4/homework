package hu.schonherz.blog.service.api.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.schonherz.blog.service.api.user.datasource.DataSourceManager;
import hu.schonherz.blog.service.api.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.queries.UserQueries;

public class UserDAO implements GenericDAO<UserDTO> {

    @Override
    public UserDTO findByUserName(String username) throws UserNotFoundException{
       
        try(Connection conn = DataSourceManager.getDataSource().getConnection()){
            PreparedStatement statement = conn.prepareStatement(UserQueries.QUERY_FIND_BY_USER_NANE);
            statement.setString(1,username);
            ResultSet rs = statement.executeQuery();
            
            if(rs.next()){
               return toDTO(rs);
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new UserNotFoundException();

        
        
        
        
        
    }
    @Override
    public Collection<UserDTO> findAll(){
        List<UserDTO> users=new ArrayList<>();
        
        try(Connection conn = DataSourceManager.getDataSource().getConnection()){
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(UserQueries.QUERY_FIND_ALL);
            
            while(rs.next()){
                users.add(toDTO(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    @Override
    public int save(UserDTO dto){
        try(Connection conn = DataSourceManager.getDataSource().getConnection()){
            PreparedStatement statement = conn.prepareStatement(UserQueries.QUERY_INSERT);
            statement.setString(1, dto.getFirstName());
            statement.setString(2, dto.getLastName());
            statement.setString(3, dto.getUsername());
            statement.setString(4, dto.getEmail());
            statement.setString(5, dto.getPassword());
            statement.setString(6, dto.getGender());
            statement.setString(7, dto.getDate_of_birth());
            statement.setString(8, dto.getLocation());
            statement.setString(9, dto.getPhone());
           
            statement.executeUpdate();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
        
    }
    
    private static UserDTO toDTO(ResultSet rs) throws SQLException{
        UserDTO userDTO = new UserDTO();
        userDTO.setId(rs.getInt("id"));
        userDTO.setFirstName(rs.getString("first_name"));
        userDTO.setLastName(rs.getString("last_name"));
        userDTO.setUsername(rs.getString("username"));
        userDTO.setPassword(rs.getString("password"));
        userDTO.setEmail(rs.getString("email"));
        userDTO.setGender(rs.getString("gender"));
        userDTO.setDate_of_birth(rs.getString("date_of_birth"));
        userDTO.setLocation(rs.getString("location"));
        userDTO.setPhone(rs.getString("phone"));
        userDTO.setImg(rs.getString("img"));
        
        return userDTO;
    }
  
    }

