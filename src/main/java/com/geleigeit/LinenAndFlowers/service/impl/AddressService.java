package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Address;
import com.geleigeit.LinenAndFlowers.repository.AddressRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends AbstractService<Address, AddressRepository> {

    @Autowired
    public AddressService(AddressRepository repository) {
        super(repository);
    }
}
