package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.abstractControllers.GetMethodsAbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.Size;
import com.geleigeit.LinenAndFlowers.service.impl.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/size")
public class SizeController extends GetMethodsAbstractController<Size, SizeService> {

    @Autowired
    protected SizeController(SizeService sizeService) {
        super(sizeService);
    }
}
