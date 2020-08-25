package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.FabricCount;
import com.geleigeit.LinenAndFlowers.repository.FabricCountRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FabricCountService extends AbstractService<FabricCount, FabricCountRepository> {

    @Autowired
    public FabricCountService(FabricCountRepository repository) {
        super(repository);
    }

    @Override
    public FabricCount update(FabricCount newFabricCount) {
        FabricCount fabricCount = getOne(newFabricCount.getId());
        fabricCount.setVendorCode(newFabricCount.getVendorCode());
        fabricCount.setSize(newFabricCount.getSize());
        fabricCount.setLength(newFabricCount.getLength());
        return repository.save(fabricCount);
    }
}
