package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.repository.DeliveryServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeliveryServiceImpl {

    private final DeliveryServiceRepository repository;

    @Autowired
    public DeliveryServiceImpl(DeliveryServiceRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public long findByNameGetId(String name) {
        return repository.findByName(name).getId();
    }
}
