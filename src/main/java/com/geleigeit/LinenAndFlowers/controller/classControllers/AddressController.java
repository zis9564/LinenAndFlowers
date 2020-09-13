package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.abstractControllers.AllMethodsAbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.Address;
import com.geleigeit.LinenAndFlowers.service.impl.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/address")
public class AddressController extends AllMethodsAbstractController<Address, AddressService> {

    @Autowired
    protected AddressController(AddressService service) {
        super(service);
    }
}
