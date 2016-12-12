package hu.schonherz.blog.service.api.user.service.data.user.dao;

import java.util.Collection;

public interface GenericDAO<T> {
    Collection<T> findById(int id);
    void save(T dto);
}
