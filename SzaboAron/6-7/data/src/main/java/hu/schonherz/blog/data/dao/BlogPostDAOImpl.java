package hu.schonherz.blog.data.dao;

import hu.schonherz.blog.data.dto.BlogPostDTO;
import hu.schonherz.blog.data.mappers.BlogPostMapper;
import hu.schonherz.blog.data.querys.BlogPostQuerys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class BlogPostDAOImpl implements GenericDAO<BlogPostDTO> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostDAOImpl.class);

    @Override
    public Collection<BlogPostDTO> findAll() {

        LOGGER.debug("finding posts" + jdbcTemplate);

        List<BlogPostDTO> posts = jdbcTemplate.query(BlogPostQuerys.QUERY_FIND_ALL, new BlogPostMapper());
        LOGGER.debug(posts.get(0).toString());
        return posts;
    }

    @Override
    public BlogPostDTO findById(int id) {
        BlogPostDTO blogPost = jdbcTemplate.queryForObject(BlogPostQuerys.QUERY_FIND_BY_ID, new BlogPostMapper(), id);
        return blogPost;
    }

    @Override
    public int save(BlogPostDTO dto) {
        LOGGER.debug("saved" + dto.toString());
        return jdbcTemplate.update(BlogPostQuerys.QUERY_INSERT, dto.getPostTitle(), dto.getPostBody(),
                dto.getPostPublishTime(), dto.getUserId());

    }

}
