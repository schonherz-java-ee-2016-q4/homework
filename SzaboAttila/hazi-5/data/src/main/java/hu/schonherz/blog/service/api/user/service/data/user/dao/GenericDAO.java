package hu.schonherz.blog.service.api.user.service.data.user.dao;

public interface GenericDAO<T> {
    T findById(int id);
    void save(T dto);
}
