package hu.schonherz.blog.data.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.schonherz.blog.data.user.dto.NameDto;
import hu.schonherz.blog.data.user.mappers.NameMapper;
import hu.schonherz.blog.data.user.queries.NameQueries;

@Repository
public class NameDao implements GenericDao<NameDto> {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public NameDto findById(int id) {
        return jdbcTemplate.queryForObject(NameQueries.QUERY_FIND_BY_ID, new NameMapper(), id);
    }

    @Override
    public void save(NameDto dto) {
        jdbcTemplate.update(NameQueries.QUERY_SAVE, dto.getUser_id(), dto.getTitle(), dto.getFirst(), dto.getLast());
    }
}