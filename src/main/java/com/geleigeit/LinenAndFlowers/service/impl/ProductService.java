package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.Product;
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

    @Override
    public Product update(Product newProduct) {
        Product product = getOne(newProduct.getId());
        product.setVendorCode(newProduct.getVendorCode());
        product.setAvailable(newProduct.getAvailable());
        product.setPrice(newProduct.getPrice());
        product.setDiscount(newProduct.getDiscount());
        return repository.save(product);
    }
}
