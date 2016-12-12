package hu.schonherz.blog.service.api.user.service.data.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.schonherz.blog.service.api.user.service.data.datasource.DataSourceManager;
import hu.schonherz.blog.service.api.user.service.data.user.dto.NameDTO;
import hu.schonherz.blog.service.api.user.service.data.user.queries.NameQueries;

public class NameDAO implements GenericDAO<NameDTO> {

    @Override
    public Collection<NameDTO> findById(int id) {
        List<NameDTO> back = new ArrayList<>();

        try (Connection connection = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(NameQueries.QUERY_FIND_BY_ID);
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

    private NameDTO toDTO(ResultSet rs) throws SQLException {
        NameDTO back = new NameDTO();

        back.setFirst(rs.getString("first"));
        back.setLast(rs.getString("last"));
        back.setTitle(rs.getString("title"));
        back.setUser_id(rs.getInt("user_id"));

        return back;
    }

    @Override
    public void save(NameDTO dto) {
        try (Connection connection = DataSourceManager.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(NameQueries.QUERY_SAVE);) {

            statement.setInt(1, dto.getUser_id());
            statement.setString(2, dto.getTitle());
            statement.setString(3, dto.getFirst());
            statement.setString(4, dto.getLast());

            statement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}