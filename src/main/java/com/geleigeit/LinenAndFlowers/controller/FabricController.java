package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.entity.Fabric;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.service.impl.FabricServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("fabric")
public class FabricController {

    private final FabricServiceImpl fabricService;

    @Autowired
    public FabricController(FabricServiceImpl fabricService) {
        this.fabricService = fabricService;
    }

    @GetMapping(value = "{id}")
    public Fabric getOne(@PathVariable("id") long id) {
        try {
            return fabricService.getOne(id);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "some text", ex);
        }
    }

    @PostMapping(value = "")
    public void post(@RequestBody Fabric fabric) {
        try {
            fabricService.addFabric(fabric);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "some text", ex);
        }
    }
}
