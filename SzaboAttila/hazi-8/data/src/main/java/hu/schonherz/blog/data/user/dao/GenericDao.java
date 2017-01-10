package hu.schonherz.blog.data.user.dao;

public interface GenericDao<T> {
    T findById(int id);
    void save(T dto);
}
