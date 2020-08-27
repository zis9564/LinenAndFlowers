package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.FabricCount;
import com.geleigeit.LinenAndFlowers.repository.FabricCountRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FabricCountService extends AbstractService<FabricCount, FabricCountRepository> {

    @Autowired
    public FabricCountService(FabricCountRepository repository) {
        super(repository);
    }
    Logger logger = LogManager.getLogger(FabricCountService.class);

    @Override
    public FabricCount update(FabricCount newFabricCount) {
        FabricCount fabricCount = getOne(newFabricCount.getId());
        fabricCount.setLength(newFabricCount.getLength());
        fabricCount.setItemName(newFabricCount.getItemName());
        fabricCount.setSize(newFabricCount.getSize());
        logger.debug("fabric_count {} has updated", fabricCount.hashCode());
        return repository.save(fabricCount);
    }
}
