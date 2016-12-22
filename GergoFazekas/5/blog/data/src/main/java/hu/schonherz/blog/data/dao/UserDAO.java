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
import hu.schonherz.blog.data.dto.UserDTO;
import hu.schonherz.blog.data.queries.UserQueries;

public class UserDAO implements GenericDAO<UserDTO>{
   public Collection<UserDTO> findAll() {
        
        List<UserDTO> users = new ArrayList<>();
        
        try (Connection conn = DataSourceManager.getInstance().getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(UserQueries.QUERY_FROM_ALL);
            while (rs.next()) {
                users.add(toDTO(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error while connecting with the database!");
            e.printStackTrace();
        }
        
        return users;
    }

    public UserDTO findById(int id) {
        try(Connection conn = DataSourceManager.getInstance().getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(UserQueries.QUERY_FIND_BY_ID);
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

    public int save(UserDTO dto) {
        try(Connection conn = DataSourceManager.getInstance().getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(UserQueries.QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setInt(1, dto.getId());
            preparedStatement.setString(1, dto.getFirstName());
            preparedStatement.setString(2, dto.getLastName());
            preparedStatement.setString(3, dto.getEmail());
            preparedStatement.setString(4, dto.getUsername());
            preparedStatement.setString(5, dto.getPassword());
            preparedStatement.setString(6, dto.getPhone());
            preparedStatement.setString(7, dto.getGender());
            preparedStatement.setDate(8, dto.getDob());
            preparedStatement.setDate(9, dto.getRegistered());
            preparedStatement.setInt(10, dto.getPostcode());
            preparedStatement.setString(11, dto.getStreet());
            preparedStatement.setString(12, dto.getState());
            preparedStatement.setString(13, dto.getCity());
            preparedStatement.setString(14, dto.getLargePicture());
            preparedStatement.setString(15, dto.getMediumPicture());
            preparedStatement.setString(16, dto.getThumbnail());
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
    
    private static UserDTO toDTO(ResultSet rs) throws SQLException {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(rs.getInt("id"));
        userDTO.setFirstName(rs.getString("first_name"));
        userDTO.setLastName(rs.getString("last_name"));
        userDTO.setEmail(rs.getString("email"));
        userDTO.setUsername(rs.getString("username"));
        userDTO.setPassword(rs.getString("password"));
        userDTO.setPhone(rs.getString("phone"));
        userDTO.setGender(rs.getString("gender"));
        userDTO.setDob(rs.getDate("dob"));
        userDTO.setRegistered(rs.getDate("registered"));
        userDTO.setPostcode(rs.getInt("postcode"));
        userDTO.setStreet(rs.getString("street"));
        userDTO.setState(rs.getString("state"));
        userDTO.setCity(rs.getString("city"));
        userDTO.setLargePicture(rs.getString("large_picture"));
        userDTO.setMediumPicture(rs.getString("medium_picture"));
        userDTO.setThumbnail(rs.getString("thumbnail"));
        return userDTO;
    }

}