package hu.schonherz.jee.service.impl.user;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.schonherz.jee.core.dao.RoleDao;
import hu.schonherz.jee.core.dao.UserDao;
import hu.schonherz.jee.core.entity.RoleEntity;
import hu.schonherz.jee.core.entity.UserEntity;
import hu.schonherz.jee.service.client.api.service.user.UserServiceLocal;
import hu.schonherz.jee.service.client.api.service.user.UserServiceRemote;
import hu.schonherz.jee.service.client.api.vo.User;
import hu.schonherz.jee.service.mapper.user.UserVoMapper;

@Stateless(mappedName = "UserService")
@Remote(UserServiceRemote.class)
@Local(UserServiceLocal.class)
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UserServiceBean implements UserServiceRemote, UserServiceLocal {

    private static final String ROLE_USER = "ROLE_USER";

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Override
    public User findByUsername(String username) {
        UserEntity userEntity = userDao.findByUsername(username);
        return UserVoMapper.toVo(userEntity);

    }

    @Override
    public User registrationUser(User user) {
        UserEntity userEntity = UserVoMapper.toEntity(user);

        List<RoleEntity> roleEntities = new ArrayList<>();

        RoleEntity roleEntity = roleDao.findByName(ROLE_USER);
        roleEntities.add(roleEntity);
        userEntity.setRoles(roleEntities);

        userEntity = userDao.save(userEntity);
        return UserVoMapper.toVo(userEntity);
    }

    @Override
    public List<User> findAll() {

        return UserVoMapper.toVo(userDao.findAll());
    }

}