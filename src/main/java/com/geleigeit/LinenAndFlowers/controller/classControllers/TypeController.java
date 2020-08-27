package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.validator.classValidators.TypeValidator;
import com.geleigeit.LinenAndFlowers.controller.AbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.Type;
import com.geleigeit.LinenAndFlowers.service.impl.TypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/type")
public class TypeController extends AbstractController<Type, TypeService, TypeValidator> {

    public TypeController(TypeService service, TypeValidator validator) {
        super(service, validator);
    }
}