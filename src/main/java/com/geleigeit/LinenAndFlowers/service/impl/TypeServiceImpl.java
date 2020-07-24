package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.Type;
import com.geleigeit.LinenAndFlowers.repository.TypeRepository;
import com.geleigeit.LinenAndFlowers.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeRepository typeRepository;

    @Override
    @Transactional
    public void addType(Type type) {
        typeRepository.save(type);
    }

    @Override
    @Transactional
    public void deleteType(long id) {
        typeRepository.deleteType(id);
    }

    @Override
    @Transactional
    public void updateType(String name, long id) {
        typeRepository.updateType(name, id);
    }

    @Override
    @Transactional
    public Type getOne(long id) {
        Optional<Type> type = typeRepository.findById(id);
        if(type.isPresent()) {
            try {
                return type.get();
            } catch (NullPointerException e) {
                System.out.println("type doesn't exist");
            }
        }
        return null;
    }

    @Override
    @Transactional
    public List<Type> getAll() {
        return typeRepository.findAllByExistTrue();
    }
}
