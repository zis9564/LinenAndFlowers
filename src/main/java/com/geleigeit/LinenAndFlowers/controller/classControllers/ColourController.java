package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.abstractControllers.AllMethodsAbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.Colour;
import com.geleigeit.LinenAndFlowers.service.impl.ColourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/colour")
public class ColourController extends AllMethodsAbstractController<Colour, ColourService> {

    @Autowired
    protected ColourController(ColourService service) {
        super(service);
    }
}
