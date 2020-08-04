package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.entity.Colour;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.ColourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("colour")
public class ColourController {

    private final ColourRepository colourRepository;

    @Autowired
    public ColourController(ColourRepository colourRepository) {
        this.colourRepository = colourRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Colour>> getAll() {
        List<Colour> colourList = colourRepository.findAllByDeletedAtIsNull();
        if(colourList.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(colourList, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Colour> getOne(@PathVariable("id") Long id) {
        if(id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Colour colour = colourRepository.findById(id).orElseThrow(NotFoundException::new);
        if(colour.getDeletedAt() != null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(colour, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Colour> add(@RequestBody Colour colour) {
        if(colour == null || colour.getDeletedAt() != null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        colourRepository.save(colour);
        return new ResponseEntity<>(colour, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Colour> update(@RequestBody Colour newColour) {
        Date update = new Date();
        if(newColour == null || newColour.getDeletedAt() != null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Colour colour = colourRepository.findById(newColour.getId()).orElseThrow(NotFoundException::new);
        if(colour.getDeletedAt() != null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        colour.setColour(newColour.getColour());
        colour.setUpdatedAt(update);
        this.colourRepository.save(colour);
        return new ResponseEntity<>(colour, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Colour> delete(@PathVariable("id") Long id) {
        Date delete = new Date();
        if(id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Colour colour = colourRepository.findById(id).orElseThrow(NotFoundException::new);
        if(colour.getDeletedAt() != null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        colour.setDeletedAt(delete);
        this.colourRepository.save(colour);
        return new ResponseEntity<>(colour, HttpStatus.NO_CONTENT);
    }
}