package hu.schonherz.blog.service.user.convert;

import hu.schonherz.blog.service.api.user.service.data.user.dto.LocationDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.LoginDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.ContactDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.ImageDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.vo.Location;
import hu.schonherz.blog.service.api.user.vo.Login;
import hu.schonherz.blog.service.api.user.vo.Name;
import hu.schonherz.blog.service.api.user.vo.Picture;
import hu.schonherz.blog.service.api.user.vo.User;

public class DTOsToUser {
    private User user;

    public DTOsToUser(UserDTO userDTO, LocationDTO locationDTO, LoginDTO loginDTO, ImageDTO imageDTO,
            ContactDTO contactDTO) {
        user = new User();
        user.setCell(contactDTO.getCell());
        user.setDob(userDTO.getDob().toString());
        user.setRegistered(userDTO.getRegistered().toString());
        user.setEmail(contactDTO.getEmail());
        user.setPhone(contactDTO.getPhone());
        user.setGender(userDTO.getGender());
        
        Location location = new Location();
        location.setCity(locationDTO.getCity());
        location.setPostcode(locationDTO.getPostcode());
        location.setState(locationDTO.getState());
        location.setStreet(locationDTO.getStreet());
        user.setLocation(location);
        
        Picture picture = new Picture();
        picture.setLarge(imageDTO.getLarge());
        picture.setMedium(imageDTO.getMedium());
        picture.setThumbnail(imageDTO.getThumbnail());
        user.setPicture(picture);
        
        Login login = new Login();
        login.setPassword(loginDTO.getPassword());
        login.setUsername(loginDTO.getUsername());
        user.setLogin(login);
        
        Name name = new Name();
        name.setFirst(userDTO.getFirst());
        name.setLast(userDTO.getLast());
        name.setTitle(userDTO.getTitle());
        user.setName(name);
        
    }

    public User getUser() {
        return user;
    }

}
