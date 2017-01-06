package hu.schonherz.blog.data.dao;

import java.util.Collection;

public interface GenericDAO<T> {
    Collection<T> findAll();
    T findById(int id);
    int save(T dto);
}
