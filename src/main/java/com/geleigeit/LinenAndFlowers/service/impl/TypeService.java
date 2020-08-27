package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Type;
import com.geleigeit.LinenAndFlowers.repository.TypeRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class TypeService extends AbstractService<Type, TypeRepository> {

    public TypeService(TypeRepository typeRepository) {
        super(typeRepository);
    }
    Logger logger = LogManager.getLogger(TypeService.class);

    @Override
    public Type update(Type newType) {
        Type type = getOne(newType.getId());
        type.setType(newType.getType());
        type.setFabrics(newType.getFabrics());
        logger.debug("type {} has updated", type.hashCode());
        return repository.save(type);
    }
}