package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.abstractControllers.AllMethodsAbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.Item;
import com.geleigeit.LinenAndFlowers.service.impl.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/item")
public class ItemController extends AllMethodsAbstractController<Item, ItemService> {

    @Autowired
    protected ItemController(ItemService service) {
        super(service);
    }
}