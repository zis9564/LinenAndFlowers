package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.Type;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.TypeRepository;
import com.geleigeit.LinenAndFlowers.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    @Transactional
    public Type addType(Type type) {
        if(type == null || type.getDeletedAt() != null) throw new NotFoundException();
        return typeRepository.save(type);
    }

    @Override
    @Transactional
    public Type getOne(long id) {
        return typeRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}