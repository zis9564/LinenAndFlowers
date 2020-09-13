package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Country;
import com.geleigeit.LinenAndFlowers.repository.CountryRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends AbstractService<Country, CountryRepository> {

    @Autowired
    public CountryService(CountryRepository repository) {
        super(repository);
    }
}
