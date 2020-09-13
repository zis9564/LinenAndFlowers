package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Shop;
import com.geleigeit.LinenAndFlowers.repository.ShopRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService extends AbstractService<Shop, ShopRepository> {

    @Autowired
    public ShopService(ShopRepository repository) {
        super(repository);
    }
}
