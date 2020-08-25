package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.Discount;
import com.geleigeit.LinenAndFlowers.repository.DiscountRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService extends AbstractService<Discount, DiscountRepository> {

    @Autowired
    public DiscountService(DiscountRepository repository) {
        super(repository);
    }

    @Override
    public Discount update(Discount newDiscount) {
        Discount discount = getOne(newDiscount.getId());
        discount.setDiscountType(newDiscount.getDiscountType());
        discount.setPercent(newDiscount.getPercent());
        discount.setProducts(newDiscount.getProducts());
        return repository.save(discount);
    }
}
