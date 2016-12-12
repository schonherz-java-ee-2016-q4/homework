package hu.schonherz.blog.service.api.user.convert;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import hu.schonherz.blog.service.api.user.service.data.user.dto.LocationDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.LoginDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.NameDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.PictureDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.vo.User;

public class UserToDTO {

    private UserDTO userDTO;
    private LocationDTO locationDTO;
    private LoginDTO loginDTO;
    private PictureDTO pictureDTO;
    private NameDTO nameDTO;
    
    public UserToDTO(User user) throws ParseException {
        userDTO = new UserDTO();
        
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setCell(user.getCell());
        userDTO.setGender(user.getGender());
        userDTO.setDob( new Date ( new SimpleDateFormat("dd/MM/yyyy").parse(user.getDob()).getTime() ) );
        userDTO.setRegistered( new Date ( new SimpleDateFormat("dd/MM/yyyy").parse(user.getRegistered()).getTime() ) );
        
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
    
}
