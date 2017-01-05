package hu.schonherz.blog.service.user.convert;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import hu.schonherz.blog.data.user.dto.LocationDto;
import hu.schonherz.blog.data.user.dto.LoginDto;
import hu.schonherz.blog.data.user.dto.NameDto;
import hu.schonherz.blog.data.user.dto.PictureDto;
import hu.schonherz.blog.data.user.dto.UserDto;
import hu.schonherz.blog.service.api.user.vo.UserVo;

public class UserToUserDto {

    private UserDto userDto;
    private LocationDto locationDto;
    private LoginDto loginDto;
    private PictureDto pictureDto;
    private NameDto nameDto;
    
    public UserToUserDto(UserVo user) throws ParseException {
        userDto = new UserDto();
        
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setCell(user.getCell());
        userDto.setGender("female".equals(user.getGender()) ? "f" : "m");
        userDto.setDob( new Date ( new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(user.getDob()).getTime() ) );
        userDto.setRegistered( new Date ( new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(user.getRegistered()).getTime() ) );
        userDto.setActive(user.getActive());
        
        locationDto = new LocationDto();
        
        locationDto.setCity(user.getLocation().getCity());
        locationDto.setPostcode(user.getLocation().getPostcode());
        locationDto.setState(user.getLocation().getState());
        locationDto.setStreet(user.getLocation().getStreet());
        
        nameDto = new NameDto();
        
        nameDto.setFirst(user.getName().getFirst());
        nameDto.setLast(user.getName().getLast());
        nameDto.setTitle(user.getName().getTitle());
        
        pictureDto = new PictureDto();
        
        pictureDto.setLarge(user.getPicture().getLarge());
        pictureDto.setMedium(user.getPicture().getMedium());
        pictureDto.setThumbnail(user.getPicture().getThumbnail());
        
        loginDto = new LoginDto();
        
        loginDto.setPassword(user.getLogin().getPassword());
        loginDto.setUsername(user.getLogin().getUsername());
        
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public LocationDto getLocationDto() {
        return locationDto;
    }

    public LoginDto getLoginDto() {
        return loginDto;
    }

    public PictureDto getPictureDto() {
        return pictureDto;
    }

    public NameDto getNameDto() {
        return nameDto;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserToUserDto [userDto=");
        builder.append(userDto);
        builder.append(", locationDto=");
        builder.append(locationDto);
        builder.append(", loginDto=");
        builder.append(loginDto);
        builder.append(", pictureDto=");
        builder.append(pictureDto);
        builder.append(", nameDto=");
        builder.append(nameDto);
        builder.append("]");
        return builder.toString();
    }
}
