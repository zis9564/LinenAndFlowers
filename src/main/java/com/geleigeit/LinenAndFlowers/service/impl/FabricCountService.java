package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.FabricCount;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.FabricCountRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FabricCountService {

    private final FabricCountRepository fabricCountRepository;

    @Autowired
    public FabricCountService(FabricCountRepository fabricCountRepository) {
        this.fabricCountRepository = fabricCountRepository;
    }
    Logger logger = LogManager.getLogger(FabricCountService.class);

    public FabricCount update(FabricCount newFabricCount) {
        FabricCount fabricCount = fabricCountRepository.findById(newFabricCount.getId())
                .orElseThrow(NotFoundException::new);
        fabricCount.setLength(newFabricCount.getLength());
        fabricCount.setSize(newFabricCount.getSize());
        fabricCount.setVendorCode(newFabricCount.getVendorCode());
        logger.debug("fabric_count {} has updated", fabricCount.hashCode());
        return fabricCountRepository.save(fabricCount);
    }
}
