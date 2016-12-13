package hu.schonherz.blog.service.api.user.convert;

import hu.schonherz.blog.service.api.user.service.data.user.dto.LocationDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.LoginDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.NameDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.PictureDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.vo.Location;
import hu.schonherz.blog.service.api.user.vo.Login;
import hu.schonherz.blog.service.api.user.vo.Name;
import hu.schonherz.blog.service.api.user.vo.Picture;
import hu.schonherz.blog.service.api.user.vo.User;

public class UserDTOToUser {
    private User user;

    public UserDTOToUser(UserDTO userDTO, LocationDTO locationDTO, LoginDTO loginDTO, PictureDTO pictureDTO,
            NameDTO nameDTO) {
        user = new User();
        
        user.setCell(userDTO.getCell());
        user.setDob(userDTO.getDob().toString());
        user.setRegistered(userDTO.getRegistered().toString());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setGender(userDTO.getGender().equals("f") ? "female" : "male");
        
        Location loc = new Location();
        loc.setCity(locationDTO.getCity());
        loc.setPostcode(locationDTO.getPostcode());
        loc.setState(locationDTO.getState());
        loc.setStreet(locationDTO.getStreet());
        user.setLocation(loc);
        
        Picture picture = new Picture();
        picture.setLarge(pictureDTO.getLarge());
        picture.setMedium(pictureDTO.getMedium());
        picture.setThumbnail(pictureDTO.getThumbnail());
        user.setPicture(picture);
        
        Login login = new Login();
        login.setPassword(loginDTO.getPassword());
        login.setUsername(loginDTO.getUsername());
        user.setLogin(login);
        
        Name name = new Name();
        name.setFirst(nameDTO.getFirst());
        name.setLast(nameDTO.getLast());
        name.setTitle(nameDTO.getTitle());
        user.setName(name);
        
    }

    public User getUser() {
        return user;
    }

}
