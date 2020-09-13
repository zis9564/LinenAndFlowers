package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.repository.FabricCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FabricCountService {

    private final FabricCountRepository fabricCountRepository;

    @Autowired
    public FabricCountService(FabricCountRepository fabricCountRepository) {
        this.fabricCountRepository = fabricCountRepository;
    }

    @Transactional
    public int getLengthByVendorCodeAndSize(String vendorCode, String size) {
        return fabricCountRepository.findByVendorCodeAndSize(vendorCode, size).getLength();
    }
}