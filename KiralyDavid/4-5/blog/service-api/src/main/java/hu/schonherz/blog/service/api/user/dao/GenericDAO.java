package hu.schonherz.blog.service.api.user.dao;


import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;

import java.util.Collection;

public interface GenericDAO<T> {
    Collection<T> findAll();
    T findByUserName(String username) throws UserNotFoundException;

    int save(T dto);

}
