package hu.schonherz.blog.data.user.dao;

public interface GenericDAO<T> {
    T findById(int id);
    void save(T dto);
}
