package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.Type;
import java.util.List;

public interface TypeService {

    void addType(Type type);
    void deleteType(long id);
    void updateType(String name, long id);
    Type getOne(long id);
    List<Type> getAll();
}
