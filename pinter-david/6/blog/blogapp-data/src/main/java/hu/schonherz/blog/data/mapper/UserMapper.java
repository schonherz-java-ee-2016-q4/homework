/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonherz.blog.data.mapper;

import hu.schonherz.blog.data.dto.UserDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


/**
 *
 * @author pintyo
 */
public class UserMapper implements RowMapper<UserDTO>{

    @Override
    public UserDTO mapRow(ResultSet rs, int i) throws SQLException {
        return UserDTO.builder()
                .id(rs.getInt("id"))
                .gender(rs.getString("gender"))
                .titleName(rs.getString("title_name"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .dateOfBirth(rs.getDate("date_of_birth"))
                .email(rs.getString("email"))
                .smallPicURL(rs.getString("small_pic_url"))
                .mediumPicURL(rs.getString("medium_pic_url"))
                .largePicURL(rs.getString("large_pic_url"))
                .nationality(rs.getString("nationality"))
                .stateName(rs.getString("state_name"))
                .city(rs.getString("city"))
                .street(rs.getString("street"))
                .postCode(rs.getString("post_code"))
                .userName(rs.getString("user_name"))
                .pass(rs.getString("pass"))
                .regDate(rs.getDate("register_date"))
                .build();
    }
    
}
