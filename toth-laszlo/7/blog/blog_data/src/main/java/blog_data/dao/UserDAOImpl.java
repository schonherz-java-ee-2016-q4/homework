package blog_data.dao;

import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import blog_data.dto.UserDTO;
import blog_data.mapper.UserMapper;
import blog_data.queries.UserQueries;


@Repository
public class UserDAOImpl implements UserDAO{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	public UserDTO findbyUsername(String username) {
		try{
		return jdbcTemplate.queryForObject(UserQueries.QUERY_FIND_BY_USERNAME, 
                new UserMapper(), username);
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	public Collection<UserDTO> findAll() {
		return jdbcTemplate.query(UserQueries.QUERY_FIND_ALL,  new UserMapper());
	
	}
	public int register(UserDTO user) {
		return jdbcTemplate.update(UserQueries.UPDATE_REGISTER, user);
		
	}

}
