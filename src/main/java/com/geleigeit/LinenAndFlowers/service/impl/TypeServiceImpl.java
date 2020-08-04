package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.Type;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.TypeRepository;
import com.geleigeit.LinenAndFlowers.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
        if(type == null || type.getType() == null) throw new RuntimeException();
        return typeRepository.save(type);
    }

    @Override
    @Transactional
    public Type deleteType(long id) {
        Type type = typeRepository.findById(id).orElseThrow(NotFoundException::new);
        if(type.getDeletedAt() != null) throw new NotFoundException();
        type.setDeletedAt(new Date());
        return typeRepository.save(type);
    }

    @Override
    @Transactional
    public Type updateType(Type newType) {
        if(newType == null || newType.getType() == null) throw new RuntimeException();
        Type type = typeRepository.findById(newType.getId()).orElseThrow(NotFoundException::new);
        if(type.getDeletedAt() != null) throw new NotFoundException();
        type.setType(newType.getType());
        type.setFabrics(newType.getFabrics());
        type.setUpdatedAt(new Date());
        return typeRepository.save(type);
    }

    @Override
    @Transactional
    public Type getOne(long id) {
        return typeRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    @Transactional
    public List<Type> getAll() {
        List<Type> typeList = typeRepository.findAllByDeletedAtIsNull();
        if(typeList.isEmpty()) throw new NotFoundException();
        return typeList;
    }
}