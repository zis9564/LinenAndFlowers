package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.AbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.Item;
import com.geleigeit.LinenAndFlowers.service.impl.ItemService;
import com.geleigeit.LinenAndFlowers.validator.classValidators.ItemValidator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/item")
public class ItemController extends AbstractController<Item, ItemService, ItemValidator> {

    protected ItemController(ItemService service, ItemValidator validator) {
        super(service, validator);
    }


}