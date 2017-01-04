package hu.schonherz.blog.data.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.schonherz.blog.data.user.dto.PictureDto;
import hu.schonherz.blog.data.user.mappers.PictureMapper;
import hu.schonherz.blog.data.user.queries.PictureQueries;

@Repository
public class PictureDao implements GenericDao<PictureDto> {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public PictureDto findById(int id) {
        return jdbcTemplate.queryForObject(PictureQueries.QUERY_FIND_BY_ID, new PictureMapper(), id);
    }

    @Override
    public void save(PictureDto dto) {
        jdbcTemplate.update(PictureQueries.QUERY_SAVE, dto.getUser_id(), dto.getLarge(), dto.getMedium(), dto.getThumbnail());
    }
}