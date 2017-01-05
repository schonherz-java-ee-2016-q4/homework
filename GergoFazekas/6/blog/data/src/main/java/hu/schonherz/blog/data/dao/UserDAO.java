package hu.schonherz.blog.data.dao;

import hu.schonherz.blog.data.dto.UserDTO;
import hu.schonherz.blog.data.mapper.UserMapper;
import hu.schonherz.blog.data.queries.UserQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class UserDAO implements GenericDAO<UserDTO>{

   @Autowired
   private JdbcTemplate jdbcTemplate;

    @Override
    public Collection<UserDTO> findAll() {
        return jdbcTemplate.query(UserQueries.QUERY_FROM_ALL, new UserMapper());
    }

    @Override
    public UserDTO findById(int id) {
        return jdbcTemplate.queryForObject(UserQueries.QUERY_FIND_BY_ID, new UserMapper(), id);
    }

    @Override
    public int save(UserDTO dto) {
        return jdbcTemplate.update(UserQueries.QUERY_INSERT,
                dto.getFirstName(), dto.getLastName(), dto.getEmail(),
                dto.getUsername(), dto.getPassword(), dto.getPhone(),
                dto.getGender(), dto.getDob(), dto.getRegistered(),
                dto.getPostcode(), dto.getStreet(), dto.getState(),
                dto.getCity(), dto.getLargePicture(), dto.getMediumPicture(),
                dto.getThumbnail()
                );
    }
}