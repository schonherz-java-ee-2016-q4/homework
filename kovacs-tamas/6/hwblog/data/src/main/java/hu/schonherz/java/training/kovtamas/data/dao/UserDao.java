package hu.schonherz.java.training.kovtamas.data.dao;

import hu.schonherz.java.training.kovtamas.data.dto.UserDto;
import hu.schonherz.java.training.kovtamas.data.mapper.UserMapper;
import hu.schonherz.java.training.kovtamas.data.queries.UserQueries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements GenericDao<UserDto> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Collection<UserDto> findAll() {
        return jdbcTemplate.query(UserQueries.FIND_ALL_USER, new UserMapper());
    }

    @Override
    public UserDto findById(int id) {
        return jdbcTemplate.queryForObject(UserQueries.FIND_USER_BY_ID, new Integer[]{id}, new UserMapper());
    }

    public UserDto findByUsername(String username) {
        return jdbcTemplate.queryForObject(UserQueries.FIND_USER_BY_USERNAME, new String[]{username}, new UserMapper());
    }

    @Override
    public int save(UserDto dto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection cnctn) throws SQLException {
                PreparedStatement prStatement = cnctn.prepareStatement(
                        UserQueries.INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
                prStatement.setString(1, dto.getUsername());
                prStatement.setString(2, dto.getPassword());
                prStatement.setString(3, dto.getGender());
                prStatement.setString(4, dto.getFirstName());
                prStatement.setString(5, dto.getLastName());
                prStatement.setInt(6, dto.getPostCode());
                prStatement.setString(7, dto.getCity());
                prStatement.setString(8, dto.getStreet());
                prStatement.setString(9, dto.getEmail());
                prStatement.setDate(10, dto.getDob());
                prStatement.setDate(11, dto.getRegistered());
                prStatement.setString(12, dto.getPhone());
                prStatement.setString(13, dto.getPicUrl());

                return prStatement;
            }
        }, keyHolder);

        int generatedKey = (int) (keyHolder.getKeys().get("id"));
        dto.setId(generatedKey);
        return generatedKey;
    }

}
