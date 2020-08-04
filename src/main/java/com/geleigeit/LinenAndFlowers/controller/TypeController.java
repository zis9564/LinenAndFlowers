package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.entity.Type;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("type")
public class TypeController {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Type>> getAll() {
        List<Type> typeList = typeRepository.findAllByDeletedAtIsNull();
        if(typeList.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(typeList, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Type> getOne(@PathVariable("id") Long id) {
        if(id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Type type = typeRepository.findById(id).orElseThrow(NotFoundException::new);
        if(type.getDeletedAt() != null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Type> add(@RequestBody Type type) {
        if(type == null || type.getDeletedAt() != null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        typeRepository.save(type);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Type> update(@RequestBody Type newType) {
        Date update = new Date();
        if(newType == null || newType.getDeletedAt() != null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Type type = typeRepository.findById(newType.getId()).orElseThrow(NotFoundException::new);
        if(type.getDeletedAt() != null) return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        type.setType(newType.getType());
        type.setUpdatedAt(update);
        this.typeRepository.save(type);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Type> delete(@PathVariable("id") Long id) {
        Date delete = new Date();
        if(id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Type type = typeRepository.findById(id).orElseThrow(NotFoundException::new);
        if(type.getDeletedAt() != null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        type.setDeletedAt(delete);
        this.typeRepository.save(type);
        return new ResponseEntity<>(type, HttpStatus.NO_CONTENT);
    }
}