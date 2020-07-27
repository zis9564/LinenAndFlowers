package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.Fabric;
import com.geleigeit.LinenAndFlowers.repository.FabricRepository;
import com.geleigeit.LinenAndFlowers.service.FabricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FabricServiceImpl implements FabricService {

    @Autowired
    FabricRepository fabricRepository;

    @Override
    @Transactional
    public void addFabric(Fabric fabric) {
        fabricRepository.save(fabric);
    }

    @Override
    @Transactional
    public void deleteFabric(long id) {

    }

    @Override
    @Transactional
    public void updateFabric(int newLength, long id) {

    }

    @Override
    @Transactional
    public Fabric getOne(long id) {
        return null;
    }

    @Override
    @Transactional
    public List<Fabric> getAllFabrics() {
        return null;
    }
}