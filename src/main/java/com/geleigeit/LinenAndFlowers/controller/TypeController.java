package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.Validator.TypeValidator;
import com.geleigeit.LinenAndFlowers.entity.Type;
import com.geleigeit.LinenAndFlowers.service.impl.TypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("type")
public class TypeController extends AbstractController<Type, TypeService, TypeValidator>{

    public TypeController(TypeService service, TypeValidator validator) {
        super(service, validator);
    }
}