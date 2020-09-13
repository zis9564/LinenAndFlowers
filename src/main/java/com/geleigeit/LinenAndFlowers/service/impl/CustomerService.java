package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Customer;
import com.geleigeit.LinenAndFlowers.repository.CustomerRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends AbstractService<Customer, CustomerRepository> {

    @Autowired
    public CustomerService(CustomerRepository repository) {
        super(repository);
    }
}
