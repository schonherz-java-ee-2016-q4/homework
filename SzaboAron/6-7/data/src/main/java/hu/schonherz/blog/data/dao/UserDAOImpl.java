package hu.schonherz.blog.data.dao;

import hu.schonherz.blog.data.dto.UserDTO;
import hu.schonherz.blog.data.mappers.UserMapper;
import hu.schonherz.blog.data.querys.UserQuerys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Collection<UserDTO> findAll() {
        List<UserDTO> users = jdbcTemplate.query(UserQuerys.QUERY_FIND_ALL, new UserMapper());
        return users;
    }

    @Override
    public UserDTO findById(int id) {
        UserDTO user = jdbcTemplate.queryForObject(UserQuerys.QUERY_FIND_BY_ID, new UserMapper(), id);
        return user;
    }

    @Override
    public UserDTO findUserByUsername(String username) {
        UserDTO user = jdbcTemplate.queryForObject(UserQuerys.QUERY_FIND_BY_USERNAME, new UserMapper(), username);
        return user;
    }

    @Override
    public void switchStatus(String username, boolean active) {
        jdbcTemplate.update(UserQuerys.QUERY_CHANGE_STATUS, active, username);
    }

    @Override
    public int save(UserDTO dto) {
        return jdbcTemplate.update(UserQuerys.QUERY_INSERT, dto.getEmail(), dto.getDateOfBirth(), dto.getRegistered(),
                dto.getPhone(), dto.getStreet(), dto.getCity(), dto.getState(), dto.getPostcode(), dto.getNameTitle(),
                dto.getFirstName(), dto.getLastName(), dto.getGender(), dto.getUsername(), dto.getPassword(),
                dto.getLargePic(), dto.getMediumPic(), dto.getThumbnailPic(), dto.getRole(), dto.isActive());
    }
}
