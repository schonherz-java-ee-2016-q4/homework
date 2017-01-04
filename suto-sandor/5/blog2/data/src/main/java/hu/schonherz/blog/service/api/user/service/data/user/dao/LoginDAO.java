package hu.schonherz.blog.service.api.user.service.data.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hu.schonherz.blog.service.api.user.service.data.datasource.DataSourceManager;
import hu.schonherz.blog.service.api.user.service.data.user.dto.LoginDTO;
import hu.schonherz.blog.service.api.user.service.data.user.queries.LoginQueries;

public class LoginDAO implements GenericDAO<LoginDTO> {

    @Override
    public LoginDTO findById(int id) {
        LoginDTO back = null;

        try (Connection connection = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(LoginQueries.QUERY_FIND_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                back = toDTO(resultSet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return back;
    }
    
    public LoginDTO findByUserName(String username) {
        LoginDTO back = null;

        try (Connection connection = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(LoginQueries.QUERY_FIND_BY_USERNAME);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                back = toDTO(resultSet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return back;
    }

    private LoginDTO toDTO(ResultSet rs) throws SQLException {
        LoginDTO back = new LoginDTO();

        back.setPassword(rs.getString("password"));
        back.setUser_id(rs.getInt("user_id"));
        back.setUsername(rs.getString("username"));

        return back;
    }

    @Override
    public void save(LoginDTO dto) {
        try (Connection connection = DataSourceManager.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(LoginQueries.QUERY_SAVE);) {

            statement.setInt(1, dto.getUser_id());
            statement.setString(2, dto.getUsername());
            statement.setString(3, dto.getPassword());

            statement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}