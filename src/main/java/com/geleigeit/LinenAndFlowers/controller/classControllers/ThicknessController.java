package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.validator.classValidators.ThicknessValidator;
import com.geleigeit.LinenAndFlowers.controller.AbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.Thickness;
import com.geleigeit.LinenAndFlowers.service.impl.ThicknessService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/thickness")
public class ThicknessController extends AbstractController<Thickness, ThicknessService, ThicknessValidator> {

    public ThicknessController(ThicknessService service, ThicknessValidator validator) {
        super(service, validator);
    }
}
