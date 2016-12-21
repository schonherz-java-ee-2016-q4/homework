package hu.schonherz.blog.data.user.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.blog.data.user.dto.PictureDto;

public class PictureMapper implements RowMapper<PictureDto> {
    @Override
    public PictureDto mapRow(ResultSet rs, int arg1) throws SQLException {
        PictureDto back = new PictureDto();

        back.setLarge(rs.getString("large"));
        back.setMedium(rs.getString("medium"));
        back.setThumbnail(rs.getString("thumbnail"));
        back.setUser_id(rs.getInt("user_id"));

        return back;
    }
}
