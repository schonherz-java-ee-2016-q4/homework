package hu.schonherz.blog.service.userservice;

import hu.schonherz.blog.data.domain.UserEntity;
import hu.schonherz.blog.data.repository.UserRepository;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.UserVO;
import hu.schonherz.blog.service.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Collection<UserVO> findAllUser() {
        return UserMapper.toVo(userRepository.findAll());
    }

    @Override
    public UserVO findUserByName(String name) {
        return UserMapper.toVo(userRepository.findByUsername(name));
    }

    @Override
    public void saveUser(UserVO user) {
        userRepository.save(UserMapper.toDto(user));

    }

    @Override
    public boolean switchUserStatus(String username) {
        UserEntity user = userRepository.findByUsername(username);
        user.setActive(!user.getActive());
        userRepository.save(user);
        return user.getActive();
    }

}
