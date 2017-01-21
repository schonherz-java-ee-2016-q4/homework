package hu.schonherz.jee.service.impl.post;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.schonherz.jee.core.dao.PostDao;
import hu.schonherz.jee.core.dao.UserDao;
import hu.schonherz.jee.service.client.api.service.post.PostServiceLocal;
import hu.schonherz.jee.service.client.api.service.post.PostServiceRemote;
import hu.schonherz.jee.service.client.api.vo.Post;
import hu.schonherz.jee.service.mapper.post.PostVoMapper;

@Stateless(mappedName = "PostService")
@Remote(PostServiceRemote.class)
@Local(PostServiceLocal.class)
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PostServiceBean implements PostServiceLocal, PostServiceRemote{

    @Autowired
    private PostDao postDao;
    
    @Autowired
    private UserDao userDao;

    @Override
    public Post findById(Long id) {
        return PostVoMapper.toVo(postDao.findOne(id));
    }

    @Override
    public List<Post> findAll() {
       return PostVoMapper.toVo(postDao.findAll());
    }

    @Override
    public Post savePost(Post post) {
        return PostVoMapper.toVo(postDao.save(PostVoMapper.toEntity(post)));
        
    }
    
    
}