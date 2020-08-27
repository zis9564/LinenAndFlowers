package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.AbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.Size;
import com.geleigeit.LinenAndFlowers.service.impl.SizeService;
import com.geleigeit.LinenAndFlowers.validator.classValidators.SizeValidator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/size")
public class SizeController extends AbstractController<Size, SizeService, SizeValidator> {

    protected SizeController(SizeService service, SizeValidator validator) {
        super(service, validator);
    }
}
