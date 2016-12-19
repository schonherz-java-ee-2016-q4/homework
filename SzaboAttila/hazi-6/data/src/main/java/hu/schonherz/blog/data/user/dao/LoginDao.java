package hu.schonherz.blog.data.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import hu.schonherz.blog.data.user.dto.LoginDto;
import hu.schonherz.blog.data.user.mappers.LoginMapper;
import hu.schonherz.blog.data.user.queries.LoginQueries;

@Repository
public class LoginDao implements GenericDao<LoginDto> {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public LoginDto findById(int id) {
        return jdbcTemplate.queryForObject(LoginQueries.QUERY_FIND_BY_ID, new LoginMapper(), id);
    }
    
    public LoginDto findByUserName(String username) {
        try {
            return jdbcTemplate.queryForObject(LoginQueries.QUERY_FIND_BY_USERNAME, new LoginMapper(), username);
        } catch (DataAccessException e) {
            return null;
        }
    }


    @Override
    public void save(LoginDto dto) {
        jdbcTemplate.update(LoginQueries.QUERY_SAVE, dto.getUser_id(), dto.getUsername(), bCryptPasswordEncoder.encode(dto.getPassword()));
    }

}