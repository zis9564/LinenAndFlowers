package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.abstractControllers.AllMethodsAbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.Type;
import com.geleigeit.LinenAndFlowers.service.impl.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/type")
public class TypeController extends AllMethodsAbstractController<Type, TypeService> {

    @Autowired
    protected TypeController(TypeService service) {
        super(service);
    }
}