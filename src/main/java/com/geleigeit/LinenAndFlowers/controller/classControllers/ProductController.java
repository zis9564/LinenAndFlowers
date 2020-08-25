package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.AbstractController;
import com.geleigeit.LinenAndFlowers.entity.Product;
import com.geleigeit.LinenAndFlowers.service.impl.ProductService;
import com.geleigeit.LinenAndFlowers.validator.classValidators.ProductValidator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/product")
public class ProductController extends AbstractController<Product, ProductService, ProductValidator> {

    protected ProductController(ProductService service, ProductValidator validator) {
        super(service, validator);
    }
}
