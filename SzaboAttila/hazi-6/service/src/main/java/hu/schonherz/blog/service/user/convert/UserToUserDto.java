package hu.schonherz.blog.service.user.convert;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import hu.schonherz.blog.data.user.dto.LocationDto;
import hu.schonherz.blog.data.user.dto.LoginDto;
import hu.schonherz.blog.data.user.dto.NameDto;
import hu.schonherz.blog.data.user.dto.PictureDto;
import hu.schonherz.blog.data.user.dto.UserDto;
import hu.schonherz.blog.service.api.user.vo.User;

public class UserToUserDto {

    private UserDto userDTO;
    private LocationDto locationDTO;
    private LoginDto loginDTO;
    private PictureDto pictureDTO;
    private NameDto nameDTO;
    
    public UserToUserDto(User user) throws ParseException {
        userDTO = new UserDto();
        
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setCell(user.getCell());
        userDTO.setGender("female".equals(user.getGender()) ? "f" : "m");
        userDTO.setDob( new Date ( new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(user.getDob()).getTime() ) );
        userDTO.setRegistered( new Date ( new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(user.getRegistered()).getTime() ) );
        
        locationDTO = new LocationDto();
        
        locationDTO.setCity(user.getLocation().getCity());
        locationDTO.setPostcode(user.getLocation().getPostcode());
        locationDTO.setState(user.getLocation().getState());
        locationDTO.setStreet(user.getLocation().getStreet());
        
        nameDTO = new NameDto();
        
        nameDTO.setFirst(user.getName().getFirst());
        nameDTO.setLast(user.getName().getLast());
        nameDTO.setTitle(user.getName().getTitle());
        
        pictureDTO = new PictureDto();
        
        pictureDTO.setLarge(user.getPicture().getLarge());
        pictureDTO.setMedium(user.getPicture().getMedium());
        pictureDTO.setThumbnail(user.getPicture().getThumbnail());
        
        loginDTO = new LoginDto();
        
        loginDTO.setPassword(user.getLogin().getPassword());
        loginDTO.setUsername(user.getLogin().getUsername());
        
    }

    public UserDto getUserDTO() {
        return userDTO;
    }

    public LocationDto getLocationDTO() {
        return locationDTO;
    }

    public LoginDto getLoginDTO() {
        return loginDTO;
    }

    public PictureDto getPictureDTO() {
        return pictureDTO;
    }

    public NameDto getNameDTO() {
        return nameDTO;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserToUserDTO [userDTO=");
        builder.append(userDTO);
        builder.append(", locationDTO=");
        builder.append(locationDTO);
        builder.append(", loginDTO=");
        builder.append(loginDTO);
        builder.append(", pictureDTO=");
        builder.append(pictureDTO);
        builder.append(", nameDTO=");
        builder.append(nameDTO);
        builder.append("]");
        return builder.toString();
    }
    
    
}
