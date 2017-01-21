package hu.schonherz.java.training.kovtamas.data.dao;

import hu.schonherz.java.training.kovtamas.data.dto.UserDto;
import java.util.Collection;

public interface GenericDao<T> {

    Collection<T> findAll();

    T findById(int id);

    int save(T dto);

    void updateRole(UserDto user);

}
