package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.BaseEntity;

import java.util.Set;

public interface CommonService<E extends BaseEntity> {
    void addOne(E e);
    void delete(long id);
    E update(E newE);
    E getOne(long id);
    Set<E> getAll();
}
