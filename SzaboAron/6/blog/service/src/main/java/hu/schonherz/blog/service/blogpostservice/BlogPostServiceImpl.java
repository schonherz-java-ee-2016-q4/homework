package hu.schonherz.blog.service.blogpostservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.schonherz.blog.data.dao.GenericDAO;
import hu.schonherz.blog.data.dto.BlogPostDTO;
import hu.schonherz.blog.service.api.blogpost.service.BlogPostService;
import hu.schonherz.blog.service.api.blogpost.vo.BlogPostVO;
import hu.schonherz.blog.service.api.user.vo.UserVO;
import hu.schonherz.blog.service.userservice.UserServiceImpl;

@Service
public class BlogPostServiceImpl implements BlogPostService {
    @Autowired
    GenericDAO<BlogPostDTO> blogPostDao;
    @Autowired
    UserServiceImpl userService;

    @Override
    public List<BlogPostVO> findAllPost() {
        List<BlogPostVO> postList = new ArrayList<>();
        for (BlogPostDTO dto : blogPostDao.findAll()) {
            System.out.println(dto);
            UserVO user = userService.findUserById(dto.getUserId());
            postList.add(BlogPostVO.toVO(dto, UserVO.toDTO(user)));

        }
        return postList;
    }

    @Override
    public void savePost(BlogPostVO post) {
        blogPostDao.save(BlogPostVO.toDTO(post));

    }

    @Override
    public BlogPostVO findPostById(int id) {
        BlogPostDTO dto = blogPostDao.findById(id);
        UserVO user = userService.findUserById(dto.getUserId());
        return BlogPostVO.toVO(dto, UserVO.toDTO(user));
    }

}
