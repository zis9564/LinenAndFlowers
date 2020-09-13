package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.abstractControllers.GetMethodsAbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.DeliveryService;
import com.geleigeit.LinenAndFlowers.service.impl.DeliveryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/deliveryService")
public class DeliveryServiceController extends GetMethodsAbstractController<DeliveryService, DeliveryServiceImpl> {

    @Autowired
    protected DeliveryServiceController(DeliveryServiceImpl service) {
        super(service);
    }
}
