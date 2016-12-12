package hu.schonherz.blog.service.api.user.service.data.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.schonherz.blog.service.api.user.service.data.datasource.DataSourceManager;
import hu.schonherz.blog.service.api.user.service.data.user.dto.LocationDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.LoginDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.NameDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.PictureDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.service.data.user.queries.UserQueries;

public class UserDAO {

    public Collection<UserDTO> findAll() {
        List<UserDTO> back = new ArrayList<>();

        try (Connection connection = DataSourceManager.getDataSource().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(UserQueries.QUERY_FIND_ALL);

            while (resultSet.next()) {
                back.add(toDTO(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return back;
    }

    private UserDTO toDTO(ResultSet rs) throws SQLException {
        UserDTO back = new UserDTO();

        back.setId(rs.getInt("id"));
        back.setDob(rs.getDate("dob"));
        back.setRegistered(rs.getDate("registered"));
        back.setCell(rs.getString("cell"));
        back.setEmail(rs.getString("email"));
        back.setGender(rs.getString("gender"));
        back.setPhone(rs.getString("phone"));

        return back;
    }

    public void save(UserDTO user_dto, LocationDTO location_dto, LoginDTO login_dto, NameDTO name_dto, PictureDTO picture_dto ) {
        try (Connection connection = DataSourceManager.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(UserQueries.QUERY_SAVE,
                        Statement.RETURN_GENERATED_KEYS);) {

            statement.setString(1, user_dto.getEmail());
            statement.setDate(2, user_dto.getDob());
            statement.setDate(3, user_dto.getRegistered());
            statement.setString(4, user_dto.getPhone());
            statement.setString(5, user_dto.getCell());
            statement.setString(6, user_dto.getGender());

            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user_dto.setId(generatedKeys.getInt(1));
                location_dto.setUser_id(user_dto.getId());
                login_dto.setUser_id(user_dto.getId());
                name_dto.setUser_id(user_dto.getId());
                picture_dto.setUser_id(user_dto.getId());
                new LocationDAO().save(location_dto);
                new LoginDAO().save(login_dto);
                new NameDAO().save(name_dto);
                new PictureDAO().save(picture_dto);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
