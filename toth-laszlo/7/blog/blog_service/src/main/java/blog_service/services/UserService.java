package blog_service.services;

import java.util.Collection;

import blog_service.vo.UserVO;

public interface UserService {
	public Collection<UserVO> findAll();
	public UserVO findByUsername(String username);
	public int register(UserVO user);
}
