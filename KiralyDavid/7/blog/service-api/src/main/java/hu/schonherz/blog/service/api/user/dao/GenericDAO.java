package hu.schonherz.blog.service.api.user.dao;


import java.util.Collection;

public interface GenericDAO<T> {

    Collection<T> findAll();

    int save(T dto);

}
