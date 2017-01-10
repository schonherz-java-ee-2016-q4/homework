package hu.schonherz.blog.data;

import java.util.Collection;

/**
 * Created by Geri on 2017. 01. 03..
 */
public interface GenericDAO<T> {
    Collection<T> findAll();
    T findById(int id);
    int save(T dto);
}
