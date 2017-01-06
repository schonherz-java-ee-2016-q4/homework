package hu.schonherz.blog.service.api.user.dao;

import java.util.Collection;

import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;

public interface GenericDAO<T> {
    Collection<T> findAll();

    int save(T dto);
    
}
