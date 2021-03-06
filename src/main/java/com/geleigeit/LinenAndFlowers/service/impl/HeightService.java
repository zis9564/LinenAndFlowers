package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Height;
import com.geleigeit.LinenAndFlowers.repository.HeightRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeightService extends AbstractService<Height, HeightRepository> {

    @Autowired
    public HeightService(HeightRepository repository) {
        super(repository);
    }
}
