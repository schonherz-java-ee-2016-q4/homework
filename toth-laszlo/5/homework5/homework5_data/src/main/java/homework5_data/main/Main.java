package homework5_data.main;

import homework5_data.dao.PostDAO;
import homework5_data.dao.UserDAO;
import homework5_data.dto.PostDTO;

public class Main {
    
    public static void main(String[] args){
        UserDAO userDAO = new UserDAO();
        PostDAO postDAO = new PostDAO();
        
        PostDTO postDTO = new PostDTO();
        postDTO.setHeader("header");
        postDTO.setText("text");
        postDTO.setUsername("fsdf");
        System.out.println(postDAO.save(postDTO));
        System.out.println(postDAO.findAll());
        System.out.println(postDAO.findById(1));
       // System.out.println(userDAO.findByUserName("dratech"));
        
        
        
    }
    
}
