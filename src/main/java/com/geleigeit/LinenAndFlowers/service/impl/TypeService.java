package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Type;
import com.geleigeit.LinenAndFlowers.repository.TypeRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService extends AbstractService<Type, TypeRepository> {

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        super(typeRepository);
    }
}