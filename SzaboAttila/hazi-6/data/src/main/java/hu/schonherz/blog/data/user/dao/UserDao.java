package hu.schonherz.blog.data.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import hu.schonherz.blog.data.user.dto.LocationDto;
import hu.schonherz.blog.data.user.dto.LoginDto;
import hu.schonherz.blog.data.user.dto.NameDto;
import hu.schonherz.blog.data.user.dto.PictureDto;
import hu.schonherz.blog.data.user.dto.UserDto;
import hu.schonherz.blog.data.user.mappers.UserMapper;
import hu.schonherz.blog.data.user.queries.UserQueries;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private GenericDao<LocationDto> locationDao;
    @Autowired
    private LoginDao loginDao;
    @Autowired
    private GenericDao<NameDto> nameDao;
    @Autowired
    private GenericDao<PictureDto> pictureDao;

    public Collection<UserDto> findAll() {
        return jdbcTemplate.query(UserQueries.QUERY_FIND_ALL, new UserMapper());
    }

    public UserDto findByUsername(String username) {
        LoginDto login_dto = loginDao.findByUserName(username);
        if (login_dto != null) {
            return findById(login_dto.getUser_id());
        } else {
            return null;
        }
    }

    public UserDto findById(int id) {
        return jdbcTemplate.queryForObject(UserQueries.QUERY_FIND_BY_ID, new UserMapper(), id);
    }

    public void save(UserDto user_dto, LocationDto location_dto, LoginDto login_dto, NameDto name_dto,
            PictureDto picture_dto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement statement = connection.prepareStatement(UserQueries.QUERY_SAVE,
                        Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, user_dto.getEmail());
                statement.setDate(2, user_dto.getDob());
                statement.setDate(3, user_dto.getRegistered());
                statement.setString(4, user_dto.getPhone());
                statement.setString(5, user_dto.getCell());
                statement.setString(6, user_dto.getGender());
                return statement;
            }
        }, keyHolder);
        
        user_dto.setId((int)keyHolder.getKeys().get("id"));
        location_dto.setUser_id(user_dto.getId());
        login_dto.setUser_id(user_dto.getId());
        name_dto.setUser_id(user_dto.getId());
        picture_dto.setUser_id(user_dto.getId());

        locationDao.save(location_dto);
        loginDao.save(login_dto);
        nameDao.save(name_dto);
        pictureDao.save(picture_dto);
    }
    
    public void changeUserStatus(int id, boolean active) {
    	jdbcTemplate.update(UserQueries.QUERY_CHANGE_STATUS, active, id);
    }

}
