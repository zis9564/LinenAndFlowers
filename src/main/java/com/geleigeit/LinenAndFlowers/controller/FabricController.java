package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.entity.Fabric;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.FabricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("fabric")
public class FabricController {

    private final FabricRepository fabricRepository;

    @Autowired
    public FabricController(FabricRepository fabricRepository) {
        this.fabricRepository = fabricRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Fabric>> getAll() {
        List<Fabric> fabricList = fabricRepository.findAllByDeletedAtIsNull();
        if(fabricList.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(fabricList, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Fabric> getOne(@PathVariable("id") Long id) {
        if(id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Fabric fabric = this.fabricRepository.findById(id).orElseThrow(NotFoundException::new);
        if(fabric.getDeletedAt() != null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(fabric, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Fabric> add(@RequestBody Fabric newFabric) {
        if(newFabric == null || newFabric.getDeletedAt() != null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Fabric fabric = new Fabric();
        fabric.setLength(newFabric.getLength());
        fabric.setColour(newFabric.getColour());
        fabric.setType(newFabric.getType());
        fabric.setThickness(newFabric.getThickness());
        fabricRepository.save(fabric);

        return new ResponseEntity<>(fabric, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Fabric> update(@RequestBody Fabric newFabric) {
        Date update = new Date();
        if(newFabric == null || newFabric.getDeletedAt() != null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Fabric fabric = this.fabricRepository.findById(newFabric.getId()).orElseThrow(NotFoundException::new);
        if(fabric.getDeletedAt() != null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        fabric.setLength(newFabric.getLength());
        fabric.setColour(newFabric.getColour());
        fabric.setType(newFabric.getType());
        fabric.setThickness(newFabric.getThickness());
        fabric.setUpdatedAt(update);
        this.fabricRepository.save(fabric);
        return new ResponseEntity<>(fabric, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<Fabric> delete(@PathVariable("id") Long id) {
        Date delete = new Date();
        if(id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Fabric fabric = this.fabricRepository.findById(id).orElseThrow(NotFoundException::new);
        if(fabric.getDeletedAt() != null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        fabric.setDeletedAt(delete);
        this.fabricRepository.save(fabric);
        return new ResponseEntity<>(fabric, HttpStatus.NO_CONTENT);
    }
}
