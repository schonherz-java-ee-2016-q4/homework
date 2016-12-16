package hu.schonherz.java.training.kovtamas.data.dao;

import hu.schonherz.java.training.kovtamas.data.datasource.DataSourceManager;
import hu.schonherz.java.training.kovtamas.data.dto.UserDto;
import hu.schonherz.java.training.kovtamas.data.queries.UserQueries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao implements GenericDao<UserDto> {

    private static final Logger LOG = LoggerFactory.getLogger(UserDao.class);

    @Override
    public Collection<UserDto> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserDto findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public UserDto findByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

}
