package hu.schonherz.blog.service.api.user.service.data.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hu.schonherz.blog.service.api.user.service.data.datasource.DataSourceManager;
import hu.schonherz.blog.service.api.user.service.data.user.dto.ImageDTO;
import hu.schonherz.blog.service.api.user.service.data.user.queries.ImageQueries;

public class ImageDAO implements GenericDAO<ImageDTO> {

    @Override
    public ImageDTO findById(int id) {
        ImageDTO findbyidres = null;

        try (Connection connection = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(ImageQueries.QUERY_FIND_BY_ID);
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

    private ImageDTO toDTO(ResultSet rs) throws SQLException {
        ImageDTO todtores = new ImageDTO();

        todtores.setLarge(rs.getString("large"));
        todtores.setMedium(rs.getString("medium"));
        todtores.setThumbnail(rs.getString("thumbnail"));
        todtores.setUser_id(rs.getInt("user_id"));

        return todtores;
    }

    @Override
    public void save(ImageDTO dto) {
        try (Connection connection = DataSourceManager.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(ImageQueries.QUERY_SAVE);) {
            statement.setInt(1, dto.getUser_id());
            statement.setString(2, dto.getLarge());
            statement.setString(3, dto.getMedium());
            statement.setString(4, dto.getThumbnail());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}