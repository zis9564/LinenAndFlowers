package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Fabric;
import com.geleigeit.LinenAndFlowers.repository.FabricRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class FabricService extends AbstractService<Fabric, FabricRepository> {

    @Autowired
    public FabricService(FabricRepository fabricRepository) {
        super(fabricRepository);
    }

    @Transactional
    public Set<Fabric> getAllFabricsWithSmallLength() {
        return repository.findFabricByLength();
    }
}