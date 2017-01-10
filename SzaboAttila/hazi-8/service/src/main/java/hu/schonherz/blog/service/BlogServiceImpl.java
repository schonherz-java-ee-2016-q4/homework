package hu.schonherz.blog.service;

import hu.schonherz.blog.data.domain.BlogPostEntity;
import hu.schonherz.blog.data.domain.PostTagEntity;
import hu.schonherz.blog.data.domain.UserEntity;
import hu.schonherz.blog.data.repository.BlogRepository;
import hu.schonherz.blog.data.repository.PostTagRepository;
import hu.schonherz.blog.data.repository.UserRepository;
import hu.schonherz.blog.service.api.blog.vo.BlogPost;
import hu.schonherz.blog.service.api.service.BlogService;
import hu.schonherz.blog.service.converter.BlogPostConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostTagRepository postTagRepository;

    @Override
    public List<BlogPost> getAllBlogPostHeader() {
        return BlogPostConverter.toVO(blogRepository.findAll());
    }
    
    @Override
    public BlogPost getBlogPostById(int id) {
        return BlogPostConverter.toVO(blogRepository.findOne(id));
    }
    
    @Override
    public int addNewBlogPost(BlogPost blogPost) {
        try {
            UserEntity author = userRepository.findByUsername(blogPost.getAuthor().getLogin().getUsername());
            BlogPostEntity back = blogRepository.save(BlogPostConverter.toEntity(blogPost, author));
            for (PostTagEntity tag : back.getPostTags()) {
                tag.setBlogPost(back);
                postTagRepository.save(tag);
            }
            return back.getId();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
