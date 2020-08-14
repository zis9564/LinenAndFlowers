package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.entity.Thickness;
import com.geleigeit.LinenAndFlowers.service.impl.ThicknessService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("thickness")
public class ThicknessController extends AbstractController<Thickness, ThicknessService> {

    public ThicknessController(ThicknessService service) {
        super(service);
    }
}
