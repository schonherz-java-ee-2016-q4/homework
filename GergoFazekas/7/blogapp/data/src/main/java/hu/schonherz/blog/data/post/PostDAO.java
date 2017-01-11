package hu.schonherz.blog.data.post;

import hu.schonherz.blog.data.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collection;

/**
 * Created by Geri on 2017. 01. 03..
 */
@Repository
public class PostDAO implements GenericDAO<PostDTO> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Collection<PostDTO> findAll() {
        return jdbcTemplate.query(PostQueries.QUERY_FROM_ALL, new PostMapper());
    }

    @Override
    public PostDTO findById(int id) {
        return jdbcTemplate.queryForObject(PostQueries.QUERY_FIND_BY_ID, new PostMapper(), id);
    }

    @Override
    public int save(PostDTO dto) {
        return jdbcTemplate.update(PostQueries.QUERY_INSERT,
                dto.getTitle(), dto.getContent(),
                dto.getPublished(), dto.getAuthorID()
        );
    }
}