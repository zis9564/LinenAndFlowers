package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.entity.Colour;
import com.geleigeit.LinenAndFlowers.service.impl.ColourService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("colour")
public class ColourController extends AbstractController<Colour, ColourService> {

    public ColourController(ColourService service) {
        super(service);
    }
}
