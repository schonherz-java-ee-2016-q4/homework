package hu.schonherz.blog.service.api.user.service.data.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hu.schonherz.blog.service.api.user.service.data.datasource.DataSourceManager;
import hu.schonherz.blog.service.api.user.service.data.user.dto.ContactDTO;
import hu.schonherz.blog.service.api.user.service.data.user.queries.ContactQueries;

public class ContactDAO implements GenericDAO<ContactDTO> {

    @Override
    public ContactDTO findById(int id) {
        ContactDTO findbyidres = null;

        try (Connection connection = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(ContactQueries.QUERY_FIND_BY_ID);
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

    private ContactDTO toDTO(ResultSet rs) throws SQLException {
        ContactDTO todtores = new ContactDTO();
        todtores.setUser_id(rs.getInt("user_id"));
        todtores.setEmail(rs.getString("email"));
        todtores.setPhone(rs.getString("phone"));
        todtores.setCell(rs.getString("cell"));

        return todtores;
    }

    @Override
    public void save(ContactDTO dto) {
        try (Connection connection = DataSourceManager.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(ContactQueries.QUERY_SAVE);) {
            statement.setInt(1, dto.getUser_id());
            statement.setString(2, dto.getEmail());
            statement.setString(3, dto.getPhone());
            statement.setString(4, dto.getCell());
            statement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}