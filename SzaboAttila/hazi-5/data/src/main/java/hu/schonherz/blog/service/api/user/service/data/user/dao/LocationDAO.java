package hu.schonherz.blog.service.api.user.service.data.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.schonherz.blog.service.api.user.service.data.datasource.DataSourceManager;
import hu.schonherz.blog.service.api.user.service.data.user.dto.LocationDTO;
import hu.schonherz.blog.service.api.user.service.data.user.queries.LocationQueries;

public class LocationDAO implements GenericDAO<LocationDTO> {

    @Override
    public Collection<LocationDTO> findById(int id) {
        List<LocationDTO> back = new ArrayList<>();

        try (Connection connection = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(LocationQueries.QUERY_FIND_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                back.add(toDTO(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return back;
    }

    private LocationDTO toDTO(ResultSet rs) throws SQLException {
        LocationDTO back = new LocationDTO();

        back.setCity(rs.getString("city"));
        back.setPostcode(rs.getInt("postcode"));
        back.setState(rs.getString("state"));
        back.setUser_id(rs.getInt("user_id"));
        back.setStreet(rs.getString("street"));

        return back;
    }

    @Override
    public void save(LocationDTO dto) {
        try (Connection connection = DataSourceManager.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(LocationQueries.QUERY_SAVE);) {

            statement.setInt(1, dto.getUser_id());
            statement.setString(2, dto.getStreet());
            statement.setString(3, dto.getCity());
            statement.setString(4, dto.getState());
            statement.setInt(5, dto.getPostcode());

            statement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}