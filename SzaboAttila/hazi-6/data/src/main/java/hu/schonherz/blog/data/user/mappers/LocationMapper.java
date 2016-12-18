package hu.schonherz.blog.data.user.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.blog.data.user.dto.LocationDto;

public class LocationMapper implements RowMapper<LocationDto> {

    @Override
    public LocationDto mapRow(ResultSet rs, int arg1) throws SQLException {
        LocationDto back = new LocationDto();

        back.setCity(rs.getString("city"));
        back.setPostcode(rs.getInt("postcode"));
        back.setState(rs.getString("state"));
        back.setUser_id(rs.getInt("user_id"));
        back.setStreet(rs.getString("street"));

        return back;
    }
    
}
