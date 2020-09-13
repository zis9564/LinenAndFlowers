package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.abstractControllers.AllMethodsAbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.Customer;
import com.geleigeit.LinenAndFlowers.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/customer")
public class CustomerController extends AllMethodsAbstractController<Customer, CustomerService> {

    @Autowired
    protected CustomerController(CustomerService service) {
        super(service);
    }
}
