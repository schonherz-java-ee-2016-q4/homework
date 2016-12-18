package hu.schonherz.blog.data.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import hu.schonherz.blog.blog.queries.PostQueries;
import hu.schonherz.blog.data.blog.dto.PostDto;
import hu.schonherz.blog.data.blog.dto.PostTagDto;
import hu.schonherz.blog.data.blog.mappers.PostMapper;


@Repository
public class PostDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private PostTagDao postTagDao;
    
    public Collection<PostDto> findAllHeaders() {
        return jdbcTemplate.query(PostQueries.QUERY_FIND_ALL_HEADERS, new PostMapper());
    }
    
    public PostDto findByPostId(int id) {
        return jdbcTemplate.queryForObject(PostQueries.QUERY_FIND_BY_POST_ID, new PostMapper(), id);
    }

    public int save(PostDto headerDto, List<PostTagDto> postTagDto) {
        
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement statement = connection.prepareStatement(PostQueries.QUERY_SAVE,
                        Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, headerDto.getUser_id());
                statement.setString(2, headerDto.getTitle());
                statement.setTimestamp(3, headerDto.getPosted());
                statement.setString(4, headerDto.getContent());
                
                return statement;
            }
        }, keyHolder);
        
        headerDto.setId(keyHolder.getKey().intValue());
        
        for (PostTagDto tag : postTagDto) {
            tag.setPost_id(headerDto.getId());
        }
        
        postTagDao.saveAll(postTagDto);
        return headerDto.getId();
    }
}
