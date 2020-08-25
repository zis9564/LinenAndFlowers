package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.AbstractController;
import com.geleigeit.LinenAndFlowers.entity.FabricCount;
import com.geleigeit.LinenAndFlowers.service.impl.FabricCountService;
import com.geleigeit.LinenAndFlowers.validator.classValidators.FabricCountValidator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/fabric_count")
public class FabricCountController extends AbstractController<FabricCount, FabricCountService, FabricCountValidator> {

    protected FabricCountController(FabricCountService service, FabricCountValidator validator) {
        super(service, validator);
    }
}
