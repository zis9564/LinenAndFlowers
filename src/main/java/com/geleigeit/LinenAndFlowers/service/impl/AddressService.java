package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Address;
import com.geleigeit.LinenAndFlowers.repository.AddressRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends AbstractService<Address, AddressRepository> {

    public AddressService(AddressRepository repository) {
        super(repository);
    }
    Logger logger = LogManager.getLogger(FabricCountService.class);
}
