package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.AbstractEntity;

import java.util.List;

public interface CommonService<E extends AbstractEntity> {
    void addOne(E e);
    void delete(long id);
    E update(E newE);
    E getOne(long id);
    List<E> getAll();
}
