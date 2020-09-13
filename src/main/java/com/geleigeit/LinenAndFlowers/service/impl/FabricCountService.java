package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.helpTables.FabricCount;
import com.geleigeit.LinenAndFlowers.repository.FabricCountRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FabricCountService {

    private final FabricCountRepository fabricCountRepository;
    Logger logger = LogManager.getLogger(FabricCountService.class);

    @Autowired
    public FabricCountService(FabricCountRepository fabricCountRepository) {
        this.fabricCountRepository = fabricCountRepository;
    }

    @Transactional
    public FabricCount update(FabricCount newFabricCount) {
        return fabricCountRepository.save(newFabricCount);
    }

    @Transactional
    public int getLengthByVendorCodeAndSize(String vendorCode, String size) {
        return fabricCountRepository.findByVendorCodeAndSize(vendorCode, size).getLength();
    }
}