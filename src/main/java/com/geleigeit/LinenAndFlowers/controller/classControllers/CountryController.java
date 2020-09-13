package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.abstractControllers.GetMethodsAbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.Country;
import com.geleigeit.LinenAndFlowers.service.impl.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/country")
public class CountryController extends GetMethodsAbstractController<Country, CountryService> {

    @Autowired
    protected CountryController(CountryService service) {
        super(service);
    }
}
