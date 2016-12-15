package hu.schonherz.blog.service.api.user;

import hu.schonherz.blog.service.api.user.dao.PostDAO;
import hu.schonherz.blog.service.api.user.dao.UserDAO;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        UserDAO dao = new UserDAO();
        System.out.println(dao.findAll());
        
        PostDAO dao2 = new PostDAO();
        System.out.println(dao2.findAll());
    }

}
