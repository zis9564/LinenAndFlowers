package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.abstractControllers.GetMethodsAbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.Shop;
import com.geleigeit.LinenAndFlowers.service.impl.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/shop")
public class ShopController extends GetMethodsAbstractController<Shop, ShopService> {

    @Autowired
    protected ShopController(ShopService service) {
        super(service);
    }
}
