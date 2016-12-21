package hu.schonherz.blog.service.user.convert;

import hu.schonherz.blog.data.user.dto.LocationDto;
import hu.schonherz.blog.data.user.dto.LoginDto;
import hu.schonherz.blog.data.user.dto.NameDto;
import hu.schonherz.blog.data.user.dto.PictureDto;
import hu.schonherz.blog.data.user.dto.UserDto;
import hu.schonherz.blog.service.api.user.vo.LocationVo;
import hu.schonherz.blog.service.api.user.vo.LoginVo;
import hu.schonherz.blog.service.api.user.vo.NameVo;
import hu.schonherz.blog.service.api.user.vo.PictureVo;
import hu.schonherz.blog.service.api.user.vo.UserVo;

public class UserDtoToUser {
    private UserVo user;

    public UserDtoToUser(UserDto userDto, LocationDto locationDto, LoginDto loginDto, PictureDto pictureDto,
            NameDto nameDto) {
        user = new UserVo();
        
        user.setCell(userDto.getCell());
        user.setDob(userDto.getDob().toString());
        user.setRegistered(userDto.getRegistered().toString());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setGender("f".equals(userDto.getGender()) ? "female" : "male");
        user.setRole(userDto.getRole());
        
        LocationVo loc = new LocationVo();
        loc.setCity(locationDto.getCity());
        loc.setPostcode(locationDto.getPostcode());
        loc.setState(locationDto.getState());
        loc.setStreet(locationDto.getStreet());
        user.setLocation(loc);
        
        PictureVo picture = new PictureVo();
        picture.setLarge(pictureDto.getLarge());
        picture.setMedium(pictureDto.getMedium());
        picture.setThumbnail(pictureDto.getThumbnail());
        user.setPicture(picture);
        
        LoginVo login = new LoginVo();
        login.setPassword(loginDto.getPassword());
        login.setUsername(loginDto.getUsername());
        user.setLogin(login);
        
        NameVo name = new NameVo();
        name.setFirst(nameDto.getFirst());
        name.setLast(nameDto.getLast());
        name.setTitle(nameDto.getTitle());
        user.setName(name);
        
    }

    public UserVo getUser() {
        return user;
    }

}
