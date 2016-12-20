package hu.schonherz.blog.service.user.convert;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import hu.schonherz.blog.service.api.user.service.data.user.dto.LocationDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.LoginDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.ContactDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.ImageDTO;
import hu.schonherz.blog.service.api.user.service.data.user.dto.UserDTO;
import hu.schonherz.blog.service.api.user.vo.User;

public class UserToDTOs {

    private UserDTO userDTO;
    private LocationDTO locationDTO;
    private LoginDTO loginDTO;
    private ImageDTO imageDTO;
    private ContactDTO contactDTO;
    
    public UserToDTOs(User user) throws ParseException {
        userDTO = new UserDTO();
        userDTO.setFirst(user.getName().getFirst());
        userDTO.setLast(user.getName().getLast());
        userDTO.setTitle(user.getName().getTitle());
        userDTO.setDob( new Date ( new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(user.getDob()).getTime() ) );
        userDTO.setRegistered( new Date ( new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(user.getRegistered()).getTime() ) );
        userDTO.setGender(user.getGender());
        
        locationDTO = new LocationDTO();
        locationDTO.setStreet(user.getLocation().getStreet());
        locationDTO.setCity(user.getLocation().getCity());
        locationDTO.setState(user.getLocation().getState());
        locationDTO.setPostcode(user.getLocation().getPostcode());
        
        contactDTO = new ContactDTO();
        contactDTO.setEmail(user.getEmail());
        contactDTO.setPhone(user.getPhone());
        contactDTO.setCell(user.getCell());
        
        imageDTO = new ImageDTO();
        imageDTO.setLarge(user.getPicture().getLarge());
        imageDTO.setMedium(user.getPicture().getMedium());
        imageDTO.setThumbnail(user.getPicture().getThumbnail());
        
        loginDTO = new LoginDTO();
        loginDTO.setUsername(user.getLogin().getUsername());
        loginDTO.setPassword(user.getLogin().getPassword());
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

	public ImageDTO getImageDTO() {
		return imageDTO;
	}

	public ContactDTO getContactDTO() {
		return contactDTO;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserToDTOs [userDTO=");
		builder.append(userDTO);
		builder.append(", locationDTO=");
		builder.append(locationDTO);
		builder.append(", loginDTO=");
		builder.append(loginDTO);
		builder.append(", imageDTO=");
		builder.append(imageDTO);
		builder.append(", contactDTO=");
		builder.append(contactDTO);
		builder.append("]");
		return builder.toString();
	}
}
