package hu.schonherz.blog.data.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collection;

/**
 * Created by Geri on 2017. 01. 03..
 */
@Repository
public class UserDAO implements GenericUserDAO<UserDTO> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
                dto.getUsername(), bCryptPasswordEncoder.encode(dto.getPassword()), dto.getPhone(),
                dto.getGender(), dto.getDob(), dto.getRegistered(),
                dto.getPostcode(), dto.getStreet(), dto.getState(),
                dto.getCity(), dto.getLargePicture(), dto.getMediumPicture(),
                dto.getThumbnail()
        );
    }
    @Override
    public int changeStatus(int id) {
        return jdbcTemplate.update(UserQueries.QUERY_CHANGE_STATUS, id);
    }
}
