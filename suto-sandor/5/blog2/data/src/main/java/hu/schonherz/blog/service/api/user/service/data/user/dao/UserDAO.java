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
import hu.schonherz.blog.service.api.user.service.data.user.dto.ContactDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.ImageDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.service.data.user.queries.UserQueries;

public class UserDAO {

    public Collection<UserDTO> findAll() {
        List<UserDTO> findallres = new ArrayList<>();

        try (Connection connection = DataSourceManager.getDataSource().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(UserQueries.QUERY_FIND_ALL);

            while (resultSet.next()) {
                findallres.add(toDTO(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return findallres;
    }

    public UserDTO findById(int id) {
        UserDTO findbyidres = null;

        try (Connection connection = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UserQueries.QUERY_FIND_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                findbyidres = toDTO(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return findbyidres;
    }

    public UserDTO findByUsername(String username) {
        LoginDTO logindto = new LoginDAO().findByUserName(username);
        if (logindto != null) {
            return findById(logindto.getUser_id());
        }
        else {
            return null;
        }
    }
    
    private UserDTO toDTO(ResultSet rs) throws SQLException {
        UserDTO todtores = new UserDTO();

        todtores.setId(rs.getInt("id"));
        todtores.setTitle(rs.getString("title"));
        todtores.setFirst(rs.getString("first"));
        todtores.setLast(rs.getString("last"));
        todtores.setDob(rs.getDate("dob"));
        todtores.setRegistered(rs.getDate("registered"));
        todtores.setGender(rs.getString("gender"));

        return todtores;
    }

	public void save(UserDTO userdto, LocationDTO locationdto, LoginDTO logindto, ContactDTO contactdto, ImageDTO imagedto ) {
        try (Connection connection = DataSourceManager.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(UserQueries.QUERY_SAVE,
                        Statement.RETURN_GENERATED_KEYS);) {

            statement.setString(1, userdto.getTitle());
            statement.setString(2, userdto.getFirst());
            statement.setString(3, userdto.getLast());
            statement.setDate(4, userdto.getDob());
            statement.setDate(5, userdto.getRegistered());
            statement.setString(6, userdto.getGender());

            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                userdto.setId(generatedKeys.getInt(1));
                locationdto.setUser_id(userdto.getId());
                logindto.setUser_id(userdto.getId());
                contactdto.setUser_id(userdto.getId());
                imagedto.setUser_id(userdto.getId());
                new LocationDAO().save(locationdto);
                new LoginDAO().save(logindto);
                new ContactDAO().save(contactdto);
                new ImageDAO().save(imagedto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
