package hu.schonherz.blog.service.api.user.jdbctemplate;

import hu.schonherz.blog.service.api.user.dao.UserDAO;
import hu.schonherz.blog.service.api.user.mapper.UserMapper;
import hu.schonherz.blog.service.api.user.pojo.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collection;

public class UserJDBCTemplate implements UserDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Collection<User> findAll() {
        String sql = "SELECT * FROM blog.members;";
        Collection<User> users = jdbcTemplate.query(sql, new UserMapper());
        return users;
    }

    @Override
    public User findByUserName(String username) {
        String sql = "SELECT * FROM blog.members WHERE username= ?;";
        User user = jdbcTemplate.queryForObject(sql, new UserMapper(), username);
        return user;
    }

    @Override
    public void createUser(User user) {
        String sql = "INSERT INTO blog.members (firstName, lastName, username, password, email, " +
                "gender, date_of_birth, location, phone, img) VALUES (?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(),
                user.getEmail(), user.getGender(), user.getDate_of_birth(), user.getLocation(),
                user. getPhone(), user.getImg());

    }
}
