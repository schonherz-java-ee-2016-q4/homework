package blog_service.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog_data.dao.UserDAO;
import blog_data.dto.UserDTO;
import blog_service.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO dao;
	@Autowired
	UserVO vo;
	
	public Collection<UserVO> findAll() {
		Collection<UserVO> usersVO = new ArrayList<>();
		Collection<UserDTO> usersDTO = new ArrayList<>();
		usersDTO=dao.findAll();
		for(UserDTO user : usersDTO){
			usersVO.add(toVO(user));
		}
		return usersVO;
	}

	public UserVO findByUsername(String username) {
		return toVO(dao.findbyUsername(username));
	}

	public int register(UserVO user) {
		return dao.register(toDTO(user));
	}
	
	
	public static UserVO toVO(UserDTO dto){
		UserVO vo = new UserVO();
		if(dto==null) return null;
		vo.setUsername(dto.getUsername());
		vo.setPassword(dto.getPassword());
		vo.setEmail(dto.getEmail());
		vo.setBirth_date(dto.getBirth_date());
		vo.setPicture(dto.getPicture());
		vo.setRegistration_date(dto.getRegistration_date());
		
		return vo;
	}

	
	public static UserDTO toDTO(UserVO vo){
		UserDTO dto = new UserDTO();
		
		dto.setUsername(vo.getUsername());
		dto.setPassword(vo.getPassword());
		dto.setEmail(vo.getPassword());
		dto.setBirth_date(vo.getBirth_date());
		dto.setPicture(vo.getPicture());
		dto.setRegistration_date(vo.getRegistration_date());
		
		return dto;
	}
}
