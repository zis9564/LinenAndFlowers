package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.AbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.ItemName;
import com.geleigeit.LinenAndFlowers.service.impl.ItemNameService;
import com.geleigeit.LinenAndFlowers.validator.classValidators.ItemNameValidator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/item/name")
public class ItemNameController extends AbstractController<ItemName, ItemNameService, ItemNameValidator> {

    protected ItemNameController(ItemNameService service, ItemNameValidator validator) {
        super(service, validator);
    }
}
