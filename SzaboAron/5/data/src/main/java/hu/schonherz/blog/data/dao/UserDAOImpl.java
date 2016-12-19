package hu.schonherz.blog.data.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.schonherz.blog.data.dao.querys.UserQuerys;
import hu.schonherz.blog.data.datasource.DataSourceManager;
import hu.schonherz.blog.data.dto.UserDTO;

public class UserDAOImpl implements UserDAO {

    @Override
    public Collection<UserDTO> findAll() {
        List<UserDTO> users = new ArrayList<>();

        try (Connection conn = DataSourceManager.getDataSource().getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(UserQuerys.QUERY_FIND_ALL);
            while (rs.next()) {
                users.add(toDTO(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public UserDTO findById(int id) {
        try (Connection conn = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement prepStatement = conn.prepareStatement(UserQuerys.QUERY_FIND_BY_ID);
            prepStatement.setInt(1, id);
            ResultSet rs = prepStatement.executeQuery();
            if (rs.next()) {
                return toDTO(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserDTO findUserByUsername(String username) {
        try (Connection conn = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UserQuerys.QUERY_FIND_BY_USERNAME);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return toDTO(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int save(UserDTO dto) {
        try (Connection conn = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement prepStatement = conn.prepareStatement(UserQuerys.QUERY_INSERT,
                    Statement.RETURN_GENERATED_KEYS);

            prepStatement.setString(1, dto.getEmail());
            prepStatement.setDate(2, dto.getDateOfBirth());
            prepStatement.setDate(3, dto.getRegistered());
            prepStatement.setString(4, dto.getPhone());
            prepStatement.setString(5, dto.getStreet());
            prepStatement.setString(6, dto.getCity());
            prepStatement.setString(7, dto.getState());
            prepStatement.setInt(8, dto.getPostcode());
            prepStatement.setString(9, dto.getNameTitle());
            prepStatement.setString(10, dto.getFirstName());
            prepStatement.setString(11, dto.getLastName());
            prepStatement.setString(12, dto.getGender());
            prepStatement.setString(13, dto.getUsername());
            prepStatement.setString(14, dto.getPassword());
            prepStatement.setString(15, dto.getLargePic());
            prepStatement.setString(16, dto.getMediumPic());
            prepStatement.setString(17, dto.getThumbnailPic());
            prepStatement.executeUpdate();

            ResultSet rs = prepStatement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    private static UserDTO toDTO(ResultSet rs) throws SQLException {
        UserDTO user = new UserDTO();
        user.setId(rs.getInt("id"));
        user.setNameTitle(rs.getString("name_title"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setCity(rs.getString("city"));
        user.setPostcode(rs.getInt("postcode"));
        user.setState(rs.getString("state"));
        user.setStreet(rs.getString("street"));
        user.setDateOfBirth(Date.valueOf(rs.getString("dateofbirth")));
        user.setRegistered(Date.valueOf(rs.getString("registered")));
        user.setPhone(rs.getString("phone"));
        user.setGender(rs.getString("gender"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setLargePic(rs.getString("large_pic"));
        user.setMediumPic(rs.getString("medium_pic"));
        user.setThumbnailPic(rs.getString("thumbnail_pic"));
        return user;
    }

}
