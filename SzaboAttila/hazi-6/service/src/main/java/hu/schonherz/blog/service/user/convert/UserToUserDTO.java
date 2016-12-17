package hu.schonherz.blog.service.user.convert;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import hu.schonherz.blog.data.user.dto.LocationDTO;
import hu.schonherz.blog.data.user.dto.LoginDTO;
import hu.schonherz.blog.data.user.dto.NameDTO;
import hu.schonherz.blog.data.user.dto.PictureDTO;
import hu.schonherz.blog.data.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.vo.User;

public class UserToUserDTO {

    private UserDTO userDTO;
    private LocationDTO locationDTO;
    private LoginDTO loginDTO;
    private PictureDTO pictureDTO;
    private NameDTO nameDTO;
    
    public UserToUserDTO(User user) throws ParseException {
        userDTO = new UserDTO();
        
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setCell(user.getCell());
        userDTO.setGender("female".equals(user.getGender()) ? "f" : "m");
        userDTO.setDob( new Date ( new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(user.getDob()).getTime() ) );
        userDTO.setRegistered( new Date ( new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(user.getRegistered()).getTime() ) );
        
        locationDTO = new LocationDTO();
        
        locationDTO.setCity(user.getLocation().getCity());
        locationDTO.setPostcode(user.getLocation().getPostcode());
        locationDTO.setState(user.getLocation().getState());
        locationDTO.setStreet(user.getLocation().getStreet());
        
        nameDTO = new NameDTO();
        
        nameDTO.setFirst(user.getName().getFirst());
        nameDTO.setLast(user.getName().getLast());
        nameDTO.setTitle(user.getName().getTitle());
        
        pictureDTO = new PictureDTO();
        
        pictureDTO.setLarge(user.getPicture().getLarge());
        pictureDTO.setMedium(user.getPicture().getMedium());
        pictureDTO.setThumbnail(user.getPicture().getThumbnail());
        
        loginDTO = new LoginDTO();
        
        loginDTO.setPassword(user.getLogin().getPassword());
        loginDTO.setUsername(user.getLogin().getUsername());
        
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public LocationDTO getLocationDTO() {
        return locationDTO;
    }

    public LoginDTO getLoginDTO() {
        return loginDTO;
    }

    public PictureDTO getPictureDTO() {
        return pictureDTO;
    }

    public NameDTO getNameDTO() {
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
