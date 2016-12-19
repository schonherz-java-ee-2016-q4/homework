package hu.schonherz.blog.service.blogpostservice;

import java.util.ArrayList;
import java.util.List;

import hu.schonherz.blog.data.dao.BlogPostDAOImpl;
import hu.schonherz.blog.data.dao.GenericDAO;
import hu.schonherz.blog.data.dto.BlogPostDTO;
import hu.schonherz.blog.service.api.blogpost.service.BlogPostService;
import hu.schonherz.blog.service.api.blogpost.vo.BlogPostVO;

public class BlogPostServiceImpl implements BlogPostService {

    GenericDAO<BlogPostDTO> dao = new BlogPostDAOImpl();

    @Override
    public List<BlogPostVO> findAllPost() {
        List<BlogPostVO> postList = new ArrayList<>();
        for (BlogPostDTO dto : dao.findAll()) {
            postList.add(toVO(dto));
        }
        return postList;
    }

    @Override
    public void savePost(BlogPostVO post) {
        dao.save(toDTO(post));

    }

    private static BlogPostVO toVO(BlogPostDTO dto) {
        BlogPostVO post = new BlogPostVO();
        post.setId(dto.getId());
        post.setPostBody(dto.getPostBody());
        post.setPostTitle(dto.getPostTitle());
        post.setPostPublishTime(dto.getPostPublishTime());
        post.setUserId(dto.getUserId());
        return post;
    }

    private static BlogPostDTO toDTO(BlogPostVO vo) {
        BlogPostDTO post = new BlogPostDTO();
        post.setId(vo.getId());
        post.setPostBody(vo.getPostBody());
        post.setPostTitle(vo.getPostTitle());
        post.setPostPublishTime(vo.getPostPublishTime());
        post.setUserId(vo.getUserId());
        return post;
    }

}
