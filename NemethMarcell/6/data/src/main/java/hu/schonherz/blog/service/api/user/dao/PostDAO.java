package hu.schonherz.blog.service.api.user.dao;

import hu.schonherz.blog.service.api.user.dto.PostDTO;
import hu.schonherz.blog.service.api.user.queries.PostQueries;
import hu.schonherz.blog.service.api.user.rowmapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collection;

@Repository
public class PostDAO implements GenericDAO<PostDTO> {
    JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int save(PostDTO dto){
      return jdbcTemplate.update(
              PostQueries.QUERY_INSERT_POST,
              dto.getName(),dto.getTitle(),dto.getTextArea());
    }
    @Override
    public Collection<PostDTO> findAll(){
        return jdbcTemplate.query(
                PostQueries.QUERY_FIND_ALL_POST,
                new PostMapper());
    }
}
