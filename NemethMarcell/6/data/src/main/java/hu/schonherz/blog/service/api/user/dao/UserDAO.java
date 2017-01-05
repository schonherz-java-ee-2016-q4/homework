package hu.schonherz.blog.service.api.user.dao;

import java.util.Collection;
import java.util.zip.DataFormatException;

import hu.schonherz.blog.service.api.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.queries.UserQueries;
import hu.schonherz.blog.service.api.user.rowmapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserDAO implements GenericDAO<UserDTO> {
    JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public UserDTO findByUserName(String username){
      System.out.println(jdbcTemplate == null);
       return jdbcTemplate.queryForObject(
               UserQueries.QUERY_FIND_BY_USER_NANE,
               new UserMapper(),
               username);

    }
    public Collection<UserDTO> findAll(){
      return jdbcTemplate.query(
              UserQueries.QUERY_FIND_ALL,
              new UserMapper());
    }
    public int save(UserDTO dto){
       return jdbcTemplate.update(
               UserQueries.QUERY_INSERT,
               dto);
    }
}

