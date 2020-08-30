package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.AbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.Customer;
import com.geleigeit.LinenAndFlowers.service.impl.CustomerService;
import com.geleigeit.LinenAndFlowers.validator.classValidators.CustomerValidator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/customer")
public class CustomerController extends AbstractController<Customer, CustomerService, CustomerValidator> {

    protected CustomerController(CustomerService service, CustomerValidator validator) {
        super(service, validator);
    }
}
