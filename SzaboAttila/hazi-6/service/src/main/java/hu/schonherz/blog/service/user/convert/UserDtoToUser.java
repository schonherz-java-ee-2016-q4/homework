package hu.schonherz.blog.service.user.convert;

import hu.schonherz.blog.data.user.dto.LocationDto;
import hu.schonherz.blog.data.user.dto.LoginDto;
import hu.schonherz.blog.data.user.dto.NameDto;
import hu.schonherz.blog.data.user.dto.PictureDto;
import hu.schonherz.blog.data.user.dto.UserDto;
import hu.schonherz.blog.service.api.user.vo.Location;
import hu.schonherz.blog.service.api.user.vo.Login;
import hu.schonherz.blog.service.api.user.vo.Name;
import hu.schonherz.blog.service.api.user.vo.Picture;
import hu.schonherz.blog.service.api.user.vo.User;

public class UserDtoToUser {
    private User user;

    public UserDtoToUser(UserDto userDTO, LocationDto locationDTO, LoginDto loginDTO, PictureDto pictureDTO,
            NameDto nameDTO) {
        user = new User();
        
        user.setCell(userDTO.getCell());
        user.setDob(userDTO.getDob().toString());
        user.setRegistered(userDTO.getRegistered().toString());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setGender("f".equals(userDTO.getGender()) ? "female" : "male");
        
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
