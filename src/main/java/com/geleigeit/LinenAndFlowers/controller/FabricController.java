package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.Validator.FabricValidator;
import com.geleigeit.LinenAndFlowers.entity.Fabric;
import com.geleigeit.LinenAndFlowers.service.impl.FabricService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fabric")
public class FabricController extends AbstractController<Fabric, FabricService, FabricValidator> {

    public FabricController(FabricService service, FabricValidator validator) {
        super(service, validator);
    }
}
