package hu.schonherz.blog.data.main;

import java.text.ParseException;

import hu.schonherz.blog.data.dao.GenericDAO;
import hu.schonherz.blog.data.dao.UserDAO;
import hu.schonherz.blog.data.dto.UserDTO;

public class Main {
    public static void main(String[] args) throws ParseException {
        GenericDAO<UserDTO> userDAO = new UserDAO();
        
//        ParticipantDTO dummy = new ParticipantDTO();
//        dummy.setEmail("test4@example.com");
//        dummy.setName("Nav Arton");
//        System.out.println("The generated key is: " + participantDAO.save(dummy));
//        System.out.println(participantDAO.findAll());
        System.out.println(userDAO.findAll());
    
//        UserDTO userDTO = new UserDTO();
//        userDTO.setFirstName("Test");
//        userDTO.setLastName("Elek");
//        userDTO.setEmail("test@example.com");
//        userDTO.setUsername("testelek");
//        userDTO.setPassword("pass");
//        userDTO.setPhone("063001000101");
//        userDTO.setGender("male");
//        userDTO.setDob(Date.valueOf("2000-01-01"));
//        userDTO.setRegistered(new Date(Calendar.getInstance().getTime().getTime()));
//        userDTO.setPostcode(4026);
//        userDTO.setStreet("Andrassy u.");
//        userDTO.setState("Pest megye");
//        userDTO.setCity("Budapest");
//        userDTO.setLargePicture("https://randomuser.me/api/portraits/women/73.jpg");
//        userDTO.setMediumPicture("https://randomuser.me/api/portraits/med/women/73.jpg");
//        userDTO.setThumbnail("https://randomuser.me/api/portraits/thumb/women/73.jpg");
//        userDAO.save(userDTO);
//        System.out.println(userDAO.findAll());
    }
}
