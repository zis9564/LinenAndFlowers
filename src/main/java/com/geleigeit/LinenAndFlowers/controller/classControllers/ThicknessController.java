package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.abstractControllers.AllMethodsAbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.Thickness;
import com.geleigeit.LinenAndFlowers.service.impl.ThicknessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/thickness")
public class ThicknessController extends AllMethodsAbstractController<Thickness, ThicknessService> {

    @Autowired
    protected ThicknessController(ThicknessService service) {
        super(service);
    }
}
