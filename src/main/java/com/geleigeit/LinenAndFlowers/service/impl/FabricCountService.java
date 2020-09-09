package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.FabricCount;
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
        return fabricCountRepository.save(newFabricCount);
    }

    public int getLengthByVendorCodeAndSize(String vendorCode, String size) {
        return fabricCountRepository.findByVendorCodeAndSize(vendorCode, size).getLength();
    }
}