package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.entity.Thickness;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.ThicknessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("thickness")
public class ThicknessController {

    private final ThicknessRepository thicknessRepository;

    @Autowired
    public ThicknessController(ThicknessRepository thicknessRepository) {
        this.thicknessRepository = thicknessRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Thickness>> getAll() {
        List<Thickness> thicknessList = thicknessRepository.findAllByDeletedAtIsNull();
        if(thicknessList.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(thicknessList, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Thickness> getOne(@PathVariable("id") Long id) {
        if(id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Thickness thickness = thicknessRepository.findById(id).orElseThrow(NotFoundException::new);
        if(thickness.getDeletedAt() != null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(thickness, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Thickness> add(@RequestBody Thickness thickness) {
        if (thickness == null || thickness.getDeletedAt() != null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        thicknessRepository.save(thickness);
        return new ResponseEntity<>(thickness, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Thickness> update(@RequestBody Thickness newThickness) {
        Date update = new Date();
        if(newThickness == null || newThickness.getDeletedAt() != null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Thickness thickness = this.thicknessRepository.findById(newThickness.getId()).orElseThrow(NotFoundException::new);
        if(thickness.getDeletedAt() != null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        thickness.setThickness(newThickness.getThickness());
        thickness.setUpdatedAt(update);
        this.thicknessRepository.save(thickness);
        return new ResponseEntity<>(thickness, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Thickness> delete(@PathVariable("id") Long id) {
        Date delete = new Date();
        if(id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Thickness thickness = thicknessRepository.findById(id).orElseThrow(NotFoundException::new);
        if(thickness.getDeletedAt() != null) return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        thickness.setDeletedAt(delete);
        this.thicknessRepository.save(thickness);
        return new ResponseEntity<>(thickness, HttpStatus.NO_CONTENT);
    }
}