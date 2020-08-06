package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.entity.Colour;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.service.impl.ColourServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("colour")
public class NewColourController extends BaseController {

    private static final Logger logger = LogManager.getLogger(NewColourController.class);
    private final ColourServiceImpl colourService;

    @Autowired
    public NewColourController(ColourServiceImpl colourService) {
        this.colourService = colourService;
    }

    @GetMapping(value = "{id}")
    public Colour getOne(@PathVariable("id") long id) {
        final Colour colour;
        try {
            colour = colourService.getOne(id);
        } catch (NotFoundException ex) {
            logger.error("id isn't correct");
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Provide correct Colour Id", ex);
        }
        if(colour.getDeletedAt() != null) {
            logger.error("colour doesn't exist");
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Colour doesn't exist");
        }
        return colour;
    }

    @GetMapping(value = "")
    public List<Colour> getAll() {
        try {
            return colourService.getAll();
        } catch (NotFoundException ex) {
            logger.error("list Colours is empty");
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "List Colours is empty", ex);
        }
    }

    @PostMapping(value = "")
    public void post(@RequestBody Colour colour) {
        stringLengthChecker(colour.getColour());
        try {
            colourService.addColour(colour);
        } catch (NotFoundException ex) {
            logger.error("Colour's field 'deletedAt' isn't empty");
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "field 'deletedAt' must be null", ex);
        }
    }

    @PutMapping(value = "")
    public Colour put(@RequestBody Colour colour) {
        stringLengthChecker(colour.getColour());
        try {
            return colourService.updateColour(colour);
        } catch (NotFoundException ex) {
            logger.error("Colour not found in database or field 'colour' is empty");
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Colour with id:" + colour.getId() + " not found in database", ex);
        }
    }

    @DeleteMapping(value = "{id}")
    public void remove(@PathVariable("id") long id) {
        try {
            colourService.deleteColour(id);
        } catch (NotFoundException ex) {
            logger.error("Colour id:{} doesn't exist", id);
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Colour with id:" + id + " doesn't exist", ex);
        }
    }
}