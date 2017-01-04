/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonherz.blog.service.modelmapper;

import hu.schonherz.blog.data.dto.UserDTO;
import hu.schonherz.blog.service.api.user.vo.UserVO;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;


/**
 *
 * @author pintyo
 */
@Service
public class UserModelMapper extends PropertyMap<UserDTO, UserVO>{

    @Override
    protected void configure() {
        map().setId(source.getId());
        map().setGender(source.getGender());
        map().setTitleName(source.getTitleName());
        map().setFirstName(source.getFirstName());
        map().setLastName(source.getLastName());
        map().setDateOfBirth(source.getDateOfBirth());
        map().setEmail(source.getEmail());
        map().setSmallPicURL(source.getSmallPicURL());
        map().setMediumPicURL(source.getMediumPicURL());
        map().setLargePicURL(source.getLargePicURL());
        map().setNationality(source.getNationality());
        map().setStateName(source.getStateName());
        map().setCity(source.getCity());
        map().setStreet(source.getStreet());
        map().setPostCode(source.getPostCode());
        map().setUserName(source.getUserName());
        map().setPass(source.getPass());
        map().setRegDate(source.getRegDate());
    }
    
}
