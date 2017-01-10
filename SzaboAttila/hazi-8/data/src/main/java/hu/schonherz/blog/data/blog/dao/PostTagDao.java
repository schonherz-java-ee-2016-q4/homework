package hu.schonherz.blog.data.blog.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.schonherz.blog.blog.queries.PostTagQueries;
import hu.schonherz.blog.data.blog.dto.PostTagDto;
import hu.schonherz.blog.data.blog.mappers.PostTagMapper;

@Repository
public class PostTagDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<PostTagDto> findByPostId(int id) {
        return jdbcTemplate.query(PostTagQueries.QUERY_FIND_BY_POST_ID, new PostTagMapper(), id);
    }

    public void saveAll(List<PostTagDto> dtos) {
        for (PostTagDto dto : dtos) {
            save(dto);
        }
    }
    
    public void save(PostTagDto dto) {
        jdbcTemplate.update(PostTagQueries.QUERY_SAVE, dto.getPost_id(), dto.getTag());
    }
}
