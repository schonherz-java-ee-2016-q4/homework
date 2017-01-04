package hu.schonherz.java.training.kovtamas.data.dao;

import hu.schonherz.java.training.kovtamas.data.datasource.DataSourceManager;
import hu.schonherz.java.training.kovtamas.data.dto.UserDto;
import hu.schonherz.java.training.kovtamas.data.queries.UserQueries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao implements GenericDao<UserDto> {

    private static final Logger LOG = LoggerFactory.getLogger(UserDao.class);

    @Override
    public Collection<UserDto> findAll() {
        try (Connection conn = DataSourceManager.getDataSource().getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(UserQueries.FIND_ALL_USER);
            Set<UserDto> users = new HashSet<>();
            while (results.next()) {
                users.add(convertRecordToDto(results));
            }

            return users;
        } catch (SQLException sqle) {
            LOG.warn("Find all users failed!", sqle);
            return new HashSet<>();
        }
    }

    @Override
    public UserDto findById(int id) {
        try (Connection conn = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement prStatement = conn.prepareStatement(UserQueries.FIND_USER_BY_ID);
            prStatement.setInt(1, id);

            ResultSet result = prStatement.executeQuery();
            if (result.next()) {
                return convertRecordToDto(result);
            }
            return null;
        } catch (SQLException sqle) {
            LOG.warn("Find user by id failed!", sqle);
            return null;
        }
    }

    public UserDto findByUsername(String username) {
        try (Connection conn = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement prStatement = conn.prepareStatement(UserQueries.FIND_USER_BY_USERNAME);
            prStatement.setString(1, username);

            ResultSet result = prStatement.executeQuery();
            if (result.next()) {
                return convertRecordToDto(result);
            }
            return null;
        } catch (SQLException sqle) {
            LOG.warn("Find user by id failed!", sqle);
            return null;
        }
    }

    @Override
    public int save(UserDto dto) {
        try (Connection conn = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UserQueries.INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, dto.getUsername());
            statement.setString(2, dto.getPassword());
            statement.setString(3, dto.getGender());
            statement.setString(4, dto.getFirstName());
            statement.setString(5, dto.getLastName());
            statement.setInt(6, dto.getPostCode());
            statement.setString(7, dto.getCity());
            statement.setString(8, dto.getStreet());
            statement.setString(9, dto.getEmail());
            statement.setDate(10, dto.getDob());
            statement.setDate(11, dto.getRegistered());
            statement.setString(12, dto.getPhone());
            statement.setString(13, dto.getPicUrl());

            statement.execute();

            ResultSet ids = statement.getGeneratedKeys();
            if (!ids.next()) {
                LOG.warn("Could not save user '{}' to database!", dto.getUsername());
                throw new SaveUnsuccessfulException();
            }

            return ids.getInt("id");
        } catch (SQLException sqle) {
            String message = "Could not make connection with the data source!";
            LOG.error(message, sqle);
            throw new SaveUnsuccessfulException(message, sqle);
        }
    }

    private UserDto convertRecordToDto(ResultSet record) throws SQLException {
        UserDto dto = new UserDto();

        dto.setId(record.getInt("id"));
        dto.setGender(record.getString("gender"));
        dto.setFirstName(record.getString("first_name"));
        dto.setLastName(record.getString("last_name"));
        dto.setStreet(record.getString("street"));
        dto.setCity(record.getString("city"));
        dto.setPostCode(record.getInt("post_code"));
        dto.setEmail(record.getString("email"));
        dto.setUsername(record.getString("username"));
        dto.setPassword(record.getString("password"));
        dto.setDob(record.getDate("date_of_birth"));
        dto.setRegistered(record.getDate("registered"));
        dto.setPhone(record.getString("phone"));
        dto.setPicUrl(record.getString("pic_url"));

        return dto;
    }

}
