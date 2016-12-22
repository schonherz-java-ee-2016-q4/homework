package hu.schonherz.blog.service.api.user.service;

import java.util.Collection;

import hu.schonherz.blog.data.dao.UserDAO;
import hu.schonherz.blog.data.dto.UserDTO;

public class UserResult {
    
    private Collection<UserDTO> results = new UserDAO().findAll();

    public Collection<UserDTO> getResults() {
        return results;
    }
    
    
}
