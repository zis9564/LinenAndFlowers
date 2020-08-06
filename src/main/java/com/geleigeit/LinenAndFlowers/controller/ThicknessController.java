package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.entity.Thickness;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.ThicknessRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger(ThicknessController.class);
    private final ThicknessRepository thicknessRepository;

    @Autowired
    public ThicknessController(ThicknessRepository thicknessRepository) {
        this.thicknessRepository = thicknessRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Thickness>> getAll() {
        List<Thickness> thicknessList = thicknessRepository.findAllByDeletedAtIsNull();
        if(thicknessList.isEmpty()) {
            logger.error("Cannot get List<Thickness>: thicknessList is empty");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("List<Thickness> was given to");
        return new ResponseEntity<>(thicknessList, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Thickness> getOne(@PathVariable("id") Long id) {
        if(id == null) {
            logger.error("Nullable id: {}", id);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Thickness thickness = thicknessRepository.findById(id).orElseThrow(NotFoundException::new);
        if(thickness.getDeletedAt() != null) {
            logger.error("Thickness doesn't exist Thickness: {}", thickness);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("Thickness id: {} was given to", id);
        return new ResponseEntity<>(thickness, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Thickness> add(@RequestBody Thickness thickness) {
        if (thickness == null) {
            logger.error("RequestBody is empty");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(thickness.getDeletedAt() != null) {
            logger.error("Cannot save deleted thickness (deleted at: {})", thickness.getDeletedAt());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        thicknessRepository.save(thickness);
        logger.info("Thickness saved in database Thickness: {}", thickness);
        return new ResponseEntity<>(thickness, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Thickness> update(@RequestBody Thickness newThickness) {
        if(newThickness == null) {
            logger.error("RequestBody is empty");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(newThickness.getDeletedAt() != null) {
            logger.error("RequestBody Thickness: {} marked as deleted", newThickness.getThickness());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Thickness thickness = thicknessRepository.findById(newThickness.getId()).orElseThrow(NotFoundException::new);
        if(thickness.getDeletedAt() != null) {
            logger.info("Thickness {} in database marked as deleted", thickness.getThickness());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        thicknessRepository.updateThickness(newThickness.getThickness(),
                newThickness.getFabrics(),
                new Date(),
                newThickness.getId());
        logger.info("Thickness {} updated in database", thickness.getThickness());
        return new ResponseEntity<>(thickness, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Thickness> delete(@PathVariable("id") Long id) {
        if(id == null) {
            logger.error("Request is empty");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Thickness thickness = thicknessRepository.findById(id).orElseThrow(NotFoundException::new);
        if(thickness.getDeletedAt() != null) {
            logger.error("Thickness with id: {} marked as deleted", id);
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        thicknessRepository.deleteThickness(new Date(), id);
        logger.info("Thickness with id: {} successfully deleted in database", id);
        return new ResponseEntity<>(thickness, HttpStatus.NO_CONTENT);
    }
}