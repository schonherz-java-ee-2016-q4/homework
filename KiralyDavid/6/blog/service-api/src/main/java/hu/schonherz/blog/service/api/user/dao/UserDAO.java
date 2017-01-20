package hu.schonherz.blog.service.api.user.dao;


import hu.schonherz.blog.service.api.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.mapper.UserMapper;
import hu.schonherz.blog.service.api.user.queries.UserQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Collection;

public class UserDAO implements GenericDAO<UserDTO> {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public UserDTO findByUserName(String username) {
        return jdbcTemplate.queryForObject(UserQueries.QUERY_FIND_BY_USER_NAME, new UserMapper(), username);
    }

    @Override
    public Collection<UserDTO> findAll() {
        return jdbcTemplate.query(UserQueries.QUERY_FIND_ALL, new UserMapper());
    }

    @Override
    public int save(UserDTO dto) {
        return jdbcTemplate.update(UserQueries.QUERY_INSERT, dto);
    }

}
