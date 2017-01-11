package hu.schonherz.blog.data.user;

import hu.schonherz.blog.data.GenericDAO;

/**
 * Created by Geri on 2017. 01. 08..
 */
public interface GenericUserDAO<T> extends GenericDAO<T>{
    int changeStatus(int id);
}
