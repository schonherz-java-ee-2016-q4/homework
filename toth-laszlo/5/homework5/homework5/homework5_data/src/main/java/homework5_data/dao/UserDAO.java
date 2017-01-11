package homework5_data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import homework5_data.dto.UserDTO;
import homework5_data.queries.UserQueries;
import homework5_data.source.DataSourceManager;


public class UserDAO {

    public Collection<UserDTO> findAll(){
        List<UserDTO> users = new ArrayList<>();
        
        try (Connection conn= DataSourceManager.getDataSource().getConnection()){
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(UserQueries.QUERY_FIND_ALL);
            
            while(rs.next()){
                users.add(toDTO(rs));
            }
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return users;
    }
    
    public UserDTO findByUserName(String userName){
        try(Connection conn = DataSourceManager.getDataSource().getConnection()){
            PreparedStatement statement = conn.prepareStatement(UserQueries.QUERY_FIND_BY_NAME);
            statement.setString(1, userName);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return toDTO(rs);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public int save(UserDTO DTO){
        try(Connection conn = DataSourceManager.getDataSource().getConnection()){
            PreparedStatement prepStatement = conn.prepareStatement(UserQueries.QUERY_INSERT ,Statement.RETURN_GENERATED_KEYS);
            prepStatement.setString(1, DTO.getGender());
            prepStatement.setString(2, DTO.getTitle());
            prepStatement.setString(3, DTO.getFirst_name());
            prepStatement.setString(4, DTO.getLast_name());
            prepStatement.setString(5, DTO.getStreet());
            prepStatement.setString(6, DTO.getCity());
            prepStatement.setString(7, DTO.getState());
            prepStatement.setString(8, DTO.getPostcode());
            prepStatement.setString(9, DTO.getEmail());
            prepStatement.setString(10, DTO.getUsername());
            prepStatement.setString(11, DTO.getPassword());
            prepStatement.setString(12, DTO.getSalt());
            prepStatement.setString(13, DTO.getMd5());
            prepStatement.setString(14, DTO.getSha1());
            prepStatement.setString(15, DTO.getSha256());
            prepStatement.setString(16, DTO.getDob());
            prepStatement.setString(17, DTO.getRegistered());
            prepStatement.setString(18, DTO.getPhone());
            prepStatement.setString(19, DTO.getCell());
            prepStatement.setString(20, DTO.getId_name());
            prepStatement.setString(21, DTO.getId_value());
            prepStatement.setString(22, DTO.getPic_large());
            prepStatement.setString(23, DTO.getPic_medium());
            prepStatement.setString(24, DTO.getPic_thumbnail());
            prepStatement.setString(25, DTO.getNat());
            prepStatement.executeLargeUpdate();
            
            ResultSet rs = prepStatement.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt("id");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return 0;
    }
    
    
    private static UserDTO toDTO(ResultSet rs) throws SQLException{
        UserDTO userDTO = new UserDTO();
        userDTO.setGender(rs.getString("gender"));
        userDTO.setTitle(rs.getString("title"));
        userDTO.setFirst_name(rs.getString("first_name"));
        userDTO.setLast_name(rs.getString("last_name"));
        userDTO.setStreet(rs.getString("street"));
        userDTO.setCity(rs.getString("city"));
        userDTO.setState(rs.getString("state"));
        userDTO.setPostcode(rs.getString("postcode"));
        userDTO.setEmail(rs.getString("email"));
        userDTO.setUsername(rs.getString("username"));
        userDTO.setPassword(rs.getString("password"));
        userDTO.setSalt(rs.getString("salt"));
        userDTO.setMd5(rs.getString("md5"));
        userDTO.setSha1(rs.getString("sha1"));
        userDTO.setSha256(rs.getString("sha256"));
        userDTO.setDob(rs.getString("dob"));
        userDTO.setRegistered(rs.getString("registered"));
        userDTO.setPhone(rs.getString("phone"));
        userDTO.setCell(rs.getString("cell"));
        userDTO.setId_name(rs.getString("id_name"));
        userDTO.setId_value(rs.getString("id_value"));
        userDTO.setPic_large(rs.getString("pic_large"));
        userDTO.setPic_medium(rs.getString("pic_medium"));
        userDTO.setPic_thumbnail(rs.getString("pic_thumbnail"));
        userDTO.setNat(rs.getString("nat"));

        
        
        return userDTO;
    }
}
