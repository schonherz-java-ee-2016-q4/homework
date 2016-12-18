package hu.schonherz.blog.data.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.schonherz.blog.data.user.dto.LocationDto;
import hu.schonherz.blog.data.user.mappers.LocationMapper;
import hu.schonherz.blog.data.user.queries.LocationQueries;

@Repository
public class LocationDao implements GenericDao<LocationDto> {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public LocationDto findById(int id) {
        return jdbcTemplate.queryForObject(LocationQueries.QUERY_FIND_BY_ID, new LocationMapper(), id);
    }

    @Override
    public void save(LocationDto dto) {
        jdbcTemplate.update(LocationQueries.QUERY_SAVE, dto.getUser_id(), dto.getStreet(), dto.getCity(), dto.getState(), dto.getPostcode());
    }

}