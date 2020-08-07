package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.entity.Fabric;
import com.geleigeit.LinenAndFlowers.entity.Thickness;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.ThicknessRepository;
import com.geleigeit.LinenAndFlowers.service.impl.ThicknessServiceImpl;
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
@RequestMapping("thickness")
public class ThicknessController {

    private static final Logger logger = LogManager.getLogger(ThicknessController.class);
    private final ThicknessServiceImpl thicknessService;

    @Autowired
    public ThicknessController(ThicknessServiceImpl thicknessService) {
        this.thicknessService = thicknessService;
    }

    @GetMapping(value = "{id}")
    public Thickness getOne(@PathVariable("id") long id) {
        try {
            return thicknessService.getOne(id);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "colour doesn't exist", ex);
        }
    }

    @PostMapping(value = "")
    public void post(@RequestBody Thickness thickness) {
        try {
            thicknessService.addThickness(thickness);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "some text", ex);
        }
    }
}