package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Product;
import com.geleigeit.LinenAndFlowers.repository.ProductRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractService<Product, ProductRepository> {

    @Autowired
    public ProductService(ProductRepository repository) {
        super(repository);
    }
}