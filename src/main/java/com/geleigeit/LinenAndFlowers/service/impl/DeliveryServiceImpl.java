package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.DeliveryService;
import com.geleigeit.LinenAndFlowers.repository.DeliveryServiceRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeliveryServiceImpl extends AbstractService<DeliveryService, DeliveryServiceRepository> {

    @Autowired
    public DeliveryServiceImpl(DeliveryServiceRepository repository) {
        super(repository);
    }

    @Transactional
    public long findByNameGetId(String name) {
        return repository.findByName(name).getId();
    }
}
