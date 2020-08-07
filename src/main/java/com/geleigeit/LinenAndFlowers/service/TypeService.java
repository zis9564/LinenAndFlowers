package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.Type;
import java.util.List;

public interface TypeService {

    Type addType(Type type);
//    Type deleteType(long id);
//    Type updateType(Type newType);
    Type getOne(long id);
//    List<Type> getAll();
}
