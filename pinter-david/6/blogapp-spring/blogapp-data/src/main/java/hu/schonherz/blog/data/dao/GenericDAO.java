/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonherz.blog.data.dao;

/**
 *
 * @author pintyo
 */
import java.util.Collection;

public interface GenericDAO<T> {

    Collection<T> findAll();

    T findById(int id);

    int save(T dto);

}
