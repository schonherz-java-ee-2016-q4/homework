package hu.schonherz.java.training.kovtamas.data.dao;

import java.util.Collection;

public interface GenericDao<T> {

    Collection<T> findAll();

    T findById(int id);

    int save(T dto);

}
