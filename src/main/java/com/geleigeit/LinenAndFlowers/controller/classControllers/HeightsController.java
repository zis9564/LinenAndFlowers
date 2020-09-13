package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.abstractControllers.GetMethodsAbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.Height;
import com.geleigeit.LinenAndFlowers.service.impl.HeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/height")
public class HeightsController extends GetMethodsAbstractController<Height, HeightService> {

    @Autowired
    protected HeightsController(HeightService service) {
        super(service);
    }
}
