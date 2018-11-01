package com.flashdin.belajarspringweb.service;

import java.util.List;

public interface BaseService<T> {

    T save(T param);

    T update(T param);

    int delete(T param);

    T findById(int id);

    List<T> findAll();

    List<T> find();

}
