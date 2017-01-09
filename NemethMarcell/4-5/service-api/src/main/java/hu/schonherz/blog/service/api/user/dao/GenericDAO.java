package hu.schonherz.blog.service.api.user.dao;

import java.util.Collection;

import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;

public interface GenericDAO<T> {
    Collection<T> findAll();
    T findByUserName(String username) throws UserNotFoundException;
    
    int save(T dto);
    
}
