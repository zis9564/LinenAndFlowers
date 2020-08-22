package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.validator.classValidators.ColourValidator;
import com.geleigeit.LinenAndFlowers.controller.AbstractController;
import com.geleigeit.LinenAndFlowers.entity.Colour;
import com.geleigeit.LinenAndFlowers.service.impl.ColourService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/colour")
public class ColourController extends AbstractController<Colour, ColourService, ColourValidator> {

    public ColourController(ColourService service, ColourValidator validator) {
        super(service, validator);
    }
}
