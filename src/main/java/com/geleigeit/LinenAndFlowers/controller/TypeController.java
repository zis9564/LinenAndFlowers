package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.entity.Fabric;
import com.geleigeit.LinenAndFlowers.entity.Type;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.TypeRepository;
import com.geleigeit.LinenAndFlowers.service.impl.TypeServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("type")
public class TypeController {

    private static final Logger logger = LogManager.getLogger(TypeController.class);
    private final TypeServiceImpl typeService;

    @Autowired
    public TypeController(TypeServiceImpl typeService) {
        this.typeService = typeService;
    }

    @GetMapping(value = "{id}")
    public Type getOne(@PathVariable("id") long id) {
        try {
            return typeService.getOne(id);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "some text", ex);
        }
    }

    @PostMapping(value = "")
    public void post(@RequestBody Type type) {
        try {
            typeService.addType(type);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "some text", ex);
        }
    }
}