package hu.schonherz.blog.data.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hu.schonherz.blog.data.datasource.DataSourceManager;
import hu.schonherz.blog.data.user.dto.PictureDTO;
import hu.schonherz.blog.data.user.queries.PictureQueries;

public class PictureDAO implements GenericDAO<PictureDTO> {

    @Override
    public PictureDTO findById(int id) {
        PictureDTO back = null;

        try (Connection connection = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(PictureQueries.QUERY_FIND_BY_ID);
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

    private PictureDTO toDTO(ResultSet rs) throws SQLException {
        PictureDTO back = new PictureDTO();

        back.setLarge(rs.getString("large"));
        back.setMedium(rs.getString("medium"));
        back.setThumbnail(rs.getString("thumbnail"));
        back.setUser_id(rs.getInt("user_id"));

        return back;
    }

    @Override
    public void save(PictureDTO dto) {
        try (Connection connection = DataSourceManager.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(PictureQueries.QUERY_SAVE);) {

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