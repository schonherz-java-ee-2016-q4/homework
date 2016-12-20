package hu.schonherz.blog.service.api.user.service.data.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hu.schonherz.blog.service.api.user.service.data.datasource.DataSourceManager;
import hu.schonherz.blog.service.api.user.service.data.user.dto.LocationDTO;
import hu.schonherz.blog.service.api.user.service.data.user.queries.LocationQueries;

public class LocationDAO implements GenericDAO<LocationDTO> {

    @Override
    public LocationDTO findById(int id) {
        LocationDTO findbyidres = null;

        try (Connection connection = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(LocationQueries.QUERY_FIND_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                findbyidres = toDTO(resultSet) ;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return findbyidres;
    }

    private LocationDTO toDTO(ResultSet rs) throws SQLException {
        LocationDTO todtores = new LocationDTO();
        todtores.setUser_id(rs.getInt("user_id"));
        todtores.setStreet(rs.getString("street"));
        todtores.setCity(rs.getString("city"));
        todtores.setState(rs.getString("state"));
        todtores.setPostcode(rs.getString("postcode"));

        return todtores;
    }

    @Override
    public void save(LocationDTO dto) {
        try (Connection connection = DataSourceManager.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(LocationQueries.QUERY_SAVE);) {

            statement.setInt(1, dto.getUser_id());
            statement.setString(2, dto.getStreet());
            statement.setString(3, dto.getCity());
            statement.setString(4, dto.getState());
            statement.setString(5, dto.getPostcode());

            statement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}