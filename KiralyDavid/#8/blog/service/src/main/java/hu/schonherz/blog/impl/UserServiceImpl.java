package hu.schonherz.blog.impl;

import hu.schonherz.blog.core.repository.UserRepository;
import hu.schonherz.blog.mapper.UserMapper;
import hu.schonherz.blog.service.UserService;
import hu.schonherz.blog.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserVO findByUserName(String username) {
        return UserMapper.toVo(userRepository.findByUsername(username));
    }

    @Override
    public Collection<UserVO> findAll() {
        return UserMapper.toVo(userRepository.findAll());
    }

    @Override
    public void save(UserVO vo) {
        userRepository.save(UserMapper.toDto(vo));
    }
}
