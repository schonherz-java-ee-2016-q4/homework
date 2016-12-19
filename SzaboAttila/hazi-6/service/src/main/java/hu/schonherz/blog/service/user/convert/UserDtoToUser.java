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

    public UserDtoToUser(UserDto userDto, LocationDto locationDto, LoginDto loginDto, PictureDto pictureDto,
            NameDto nameDto) {
        user = new User();
        
        user.setCell(userDto.getCell());
        user.setDob(userDto.getDob().toString());
        user.setRegistered(userDto.getRegistered().toString());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setGender("f".equals(userDto.getGender()) ? "female" : "male");
        
        Location loc = new Location();
        loc.setCity(locationDto.getCity());
        loc.setPostcode(locationDto.getPostcode());
        loc.setState(locationDto.getState());
        loc.setStreet(locationDto.getStreet());
        user.setLocation(loc);
        
        Picture picture = new Picture();
        picture.setLarge(pictureDto.getLarge());
        picture.setMedium(pictureDto.getMedium());
        picture.setThumbnail(pictureDto.getThumbnail());
        user.setPicture(picture);
        
        Login login = new Login();
        login.setPassword(loginDto.getPassword());
        login.setUsername(loginDto.getUsername());
        user.setLogin(login);
        
        Name name = new Name();
        name.setFirst(nameDto.getFirst());
        name.setLast(nameDto.getLast());
        name.setTitle(nameDto.getTitle());
        user.setName(name);
        
    }

    public User getUser() {
        return user;
    }

}
