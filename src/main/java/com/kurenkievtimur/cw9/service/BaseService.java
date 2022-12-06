package com.kurenkievtimur.cw9.service;

import java.util.List;

public interface BaseService<T> {
    T create(T t);

    T saveOrUpdate(T t);

    T delete(T t);

    T findById(Long id);

    List<T> findAll();
}
