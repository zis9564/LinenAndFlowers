package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.AbstractController;
import com.geleigeit.LinenAndFlowers.entity.Discount;
import com.geleigeit.LinenAndFlowers.service.impl.DiscountService;
import com.geleigeit.LinenAndFlowers.validator.classValidators.DiscountValidator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/discount")
public class DiscountController extends AbstractController<Discount, DiscountService, DiscountValidator> {

    protected DiscountController(DiscountService service, DiscountValidator validator) {
        super(service, validator);
    }
}
