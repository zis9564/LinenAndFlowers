package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.abstractControllers.AllMethodsAbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.Fabric;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.service.impl.FabricService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@RestController
@RequestMapping("api/fabric")
public class FabricController extends AllMethodsAbstractController<Fabric, FabricService> {

    private final FabricService fabricService;
    private final Logger logger = LogManager.getLogger(AllMethodsAbstractController.class);

    @Autowired
    protected FabricController(FabricService service) {
        super(service);
        this.fabricService = service;
    }

    @RequestMapping(value = "/short", method = RequestMethod.GET)
    @Transactional
    public Set<Fabric> getAllSmallAmount() {
        try{
            return fabricService.getAllFabricsWithSmallLength();
        } catch (NotFoundException exception) {
            logger.error("not found Fabrics shorter than 300 centimeters");
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "not found", exception);
        }
    }
}