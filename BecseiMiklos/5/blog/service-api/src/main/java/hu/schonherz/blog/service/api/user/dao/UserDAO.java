package hu.schonherz.blog.service.api.user.dao;


import hu.schonherz.blog.service.api.user.datasource.DataSourceManager;
import hu.schonherz.blog.service.api.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.queries.UserQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDAO implements GenericDAO<UserDTO> {

    @Override
    public Collection<UserDTO> findAll() {
        List<UserDTO> users = new ArrayList<>();

        try ( Connection conn = DataSourceManager.getDataSource().getConnection() ){
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(UserQueries.QUERY_FIND_ALL);

            while(rs.next()){
                users.add(toDTO(rs));
            }

        } catch(SQLException e) {
            System.err.println("Error while communicating with the database!");
            e.printStackTrace();
        }

        return users;
    }


    @Override
    public UserDTO findByUserName(String username) throws UserNotFoundException {

        try ( Connection conn = DataSourceManager.getDataSource().getConnection() ) {
            PreparedStatement statement = conn.prepareStatement(UserQueries.QUERY_FIND_BY_USER_NAME);
            statement.setString(1,username);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return toDTO(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int save(UserDTO dto) {
        try ( Connection conn = DataSourceManager.getDataSource().getConnection() ) {
            PreparedStatement prepStatement = conn.prepareStatement(UserQueries.QUERY_INSERT);

            prepStatement.setString(1, dto.getFirstName());
            prepStatement.setString(2, dto.getLastName());
            prepStatement.setString(3, dto.getUsername());
            prepStatement.setString(4, dto.getEmail());
            prepStatement.setString(5, dto.getPassword());
            prepStatement.setString(6, dto.getGender());
            prepStatement.setString(7, dto.getDate_of_birth());
            prepStatement.setString(8, dto.getLocation());
            prepStatement.setString(9, dto.getPhone());
            prepStatement.setString(10, dto.getImg());

            prepStatement.executeUpdate();

        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        return 0;
    }

    private static UserDTO toDTO(ResultSet rs) throws SQLException {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(rs.getInt("id"));
        userDTO.setFirstName(rs.getString("firstName"));
        userDTO.setLastName(rs.getString("lastName"));
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
