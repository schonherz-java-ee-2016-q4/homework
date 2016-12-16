package homework5_service.services;

import java.util.ArrayList;
import java.util.Collection;

import homework5_data.dao.UserDAO;
import homework5_data.dto.UserDTO;
import homework5_service.vo.UserVO;

public class UserService{
    UserDAO dao = new UserDAO();
    UserVO vo = new UserVO();
    Collection<UserDTO> usersDTO = new ArrayList<>();
    Collection<UserVO> usersVO = new ArrayList<>();
    
    
    public Collection<UserVO> findAll() {       
        usersDTO=dao.findAll();
        for(UserDTO userDTO : usersDTO){
            usersVO.add(toVO(userDTO));
        }
        return usersVO;
    }



   
    public UserVO findByUserName(String name) {
        vo=toVO(dao.findByUserName(name));
        return vo;
    }



   
    public int save(UserVO userVO) {
        dao.save(toDTO(userVO));
        return 0;
    }



    public static UserDTO toDTO(UserVO userVO){
        UserDTO userDTO = new UserDTO();
        userDTO.setGender(userVO.getGender());
        userDTO.setTitle(userVO.getTitle());
        userDTO.setFirst_name(userVO.getFirst_name());
        userDTO.setLast_name(userVO.getLast_name());
        userDTO.setStreet(userVO.getStreet());
        userDTO.setCity(userVO.getCity());
        userDTO.setState(userVO.getState());
        userDTO.setPostcode(userVO.getPostcode());
        userDTO.setEmail(userVO.getEmail());
        userDTO.setUsername(userVO.getUsername());
        userDTO.setPassword(userVO.getPassword());
        userDTO.setSalt(userVO.getSalt());
        userDTO.setMd5(userVO.getMd5());
        userDTO.setSha1(userVO.getSha1());
        userDTO.setSha256(userVO.getSha256());
        userDTO.setDob(userVO.getDob());
        userDTO.setRegistered(userVO.getRegistered());
        userDTO.setPhone(userVO.getPhone());
        userDTO.setCell(userVO.getCell());
        userDTO.setId_name(userVO.getId_name());
        userDTO.setId_value(userVO.getId_value());
        userDTO.setPic_large(userVO.getPic_large());
        userDTO.setPic_medium(userVO.getPic_medium());
        userDTO.setPic_thumbnail(userVO.getPic_thumbnail());
        userDTO.setNat(userVO.getNat());
        return userDTO;
    }
    
    public static UserVO toVO(UserDTO userDTO){
        if(userDTO==null) return null;
        UserVO userVO = new UserVO();
        userVO.setGender(userDTO.getGender());
        userVO.setTitle(userDTO.getTitle());
        userVO.setFirst_name(userDTO.getFirst_name());
        userVO.setLast_name(userDTO.getLast_name());
        userVO.setStreet(userDTO.getStreet());
        userVO.setCity(userDTO.getCity());
        userVO.setState(userDTO.getState());
        userVO.setPostcode(userDTO.getPostcode());
        userVO.setEmail(userDTO.getEmail());
        userVO.setUsername(userDTO.getUsername());
        userVO.setPassword(userDTO.getPassword());
        userVO.setSalt(userDTO.getSalt());
        userVO.setMd5(userDTO.getMd5());
        userVO.setSha1(userDTO.getSha1());
        userVO.setSha256(userDTO.getSha256());
        userVO.setDob(userDTO.getDob());
        userVO.setRegistered(userDTO.getRegistered());
        userVO.setPhone(userDTO.getPhone());
        userVO.setCell(userDTO.getCell());
        userVO.setId_name(userDTO.getId_name());
        userVO.setId_value(userDTO.getId_value());
        userVO.setPic_large(userDTO.getPic_large());
        userVO.setPic_medium(userDTO.getPic_medium());
        userVO.setPic_thumbnail(userDTO.getPic_thumbnail());
        userVO.setNat(userDTO.getNat());
        return userVO;
    }

}
