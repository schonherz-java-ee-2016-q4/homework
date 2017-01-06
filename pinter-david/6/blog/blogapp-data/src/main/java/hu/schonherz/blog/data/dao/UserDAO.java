/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonherz.blog.data.dao;

import hu.schonherz.blog.data.dto.UserDTO;
import hu.schonherz.blog.data.mapper.UserMapper;
import hu.schonherz.blog.data.queries.UserQueries;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pintyo
 */
@Repository
public class UserDAO implements GenericDAO<UserDTO> {

    private static final Logger LOG = LoggerFactory.getLogger(UserDAO.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Collection<UserDTO> findAll() {
        LOG.info("UserDAO findall");

        return jdbcTemplate.query(UserQueries.QUERY_FIND_ALL, new UserMapper());

    }

    @Override
    public UserDTO findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int save(UserDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
