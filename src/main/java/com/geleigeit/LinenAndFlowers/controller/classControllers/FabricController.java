package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.AbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.Fabric;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.service.impl.FabricService;
import com.geleigeit.LinenAndFlowers.validator.classValidators.FabricValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/fabric")
public class FabricController extends AbstractController<Fabric, FabricService, FabricValidator> {

    @Autowired
    FabricService fabricService;
    private static final Logger logger = LogManager.getLogger(AbstractController.class);

    public FabricController(FabricService service, FabricValidator validator) {
        super(service, validator);
    }

    @RequestMapping(value = "/short", method = RequestMethod.GET)
    @Transactional
    public List<Fabric> getAllSmallAmount() {
        try{
            return fabricService.getAllFabricsWithSmallLength();
        } catch (NotFoundException exception) {
            logger.error("not found Fabrics shorter than 300 centimeters");
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "not found", exception);
        }
    }
}