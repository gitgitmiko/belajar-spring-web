package com.flashdin.belajarspringweb.dao;

import java.util.List;

public interface BaseDAO<T> {

    T save(T param);

    T update(T param);

    int delete(T param);

    T findById(int id);

    List<T> findAll();

}
