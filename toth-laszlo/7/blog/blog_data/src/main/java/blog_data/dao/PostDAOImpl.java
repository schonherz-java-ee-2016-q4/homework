package blog_data.dao;

import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import blog_data.dto.PostDTO;
import blog_data.mapper.PostMapper;
import blog_data.queries.PostQueries;

@Repository
public class PostDAOImpl implements PostDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public PostDTO findById(int id) {
		try{
		return jdbcTemplate.queryForObject(PostQueries.QUERY_FIND_BY_ID, 
                new PostMapper(), id);
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public Collection<PostDTO> findAll() {
		try{
		return jdbcTemplate.query(PostQueries.QUERY_FIND_ALL, 
                new PostMapper());
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}
	

	@Override
	public int post(PostDTO post) {
		return jdbcTemplate.update(PostQueries.UPDATE_POST, post);
	}

}
