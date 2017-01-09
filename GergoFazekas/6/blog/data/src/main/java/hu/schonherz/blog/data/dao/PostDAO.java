package hu.schonherz.blog.data.dao;

import java.util.Collection;
import hu.schonherz.blog.data.dto.PostDTO;
import hu.schonherz.blog.data.mapper.PostMapper;
import hu.schonherz.blog.data.queries.PostQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostDAO implements GenericDAO<PostDTO> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
