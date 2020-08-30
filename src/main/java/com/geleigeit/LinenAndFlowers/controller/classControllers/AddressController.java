package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.AbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.Address;
import com.geleigeit.LinenAndFlowers.service.impl.AddressService;
import com.geleigeit.LinenAndFlowers.validator.classValidators.AddressValidator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/address")
public class AddressController extends AbstractController<Address, AddressService, AddressValidator> {

    protected AddressController(AddressService service, AddressValidator validator) {
        super(service, validator);
    }
}
