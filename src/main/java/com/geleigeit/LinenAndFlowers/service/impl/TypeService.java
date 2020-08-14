package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.Type;
import com.geleigeit.LinenAndFlowers.repository.TypeRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeService extends AbstractService<Type, TypeRepository> {

    public TypeService(TypeRepository typeRepository) {
        super(typeRepository);
    }

    @Override
    public Type update(Type newType) {
        Type type = getOne(newType.getId());
        type.setType(newType.getType());
        type.setFabrics(newType.getFabrics());
        return repository.save(type);
    }
}