package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.entity.Type;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.TypeRepository;
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
@RequestMapping("type")
public class TypeController {

    private static final Logger logger = LogManager.getLogger(TypeController.class);
    private final TypeRepository typeRepository;

    @Autowired
    public TypeController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Type>> getAll() {
        List<Type> typeList = typeRepository.findAllByDeletedAtIsNull();
        if(typeList.isEmpty()) {
            logger.error("Cannot get List<Type>: typeList is empty");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("List<Type> was given to");
        return new ResponseEntity<>(typeList, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Type> getOne(@PathVariable("id") Long id) {
        if(id == null) {
            logger.error("Nullable id: {}", id);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Type type = typeRepository.findById(id).orElseThrow(NotFoundException::new);
        if(type.getDeletedAt() != null) {
            logger.error("Type doesn't exist Type: {} ", type);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("Type id: {} was given to", id);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Type> add(@RequestBody Type type) {
        if(type == null) {
            logger.error("RequestBody is empty");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } if(type.getDeletedAt() != null) {
            logger.error("Cannot save deleted type (deleted at: {})", type.getDeletedAt());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        typeRepository.save(type);
        logger.info("Type saved in database Type: {}", type);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Type> update(@RequestBody Type newType) {
        if(newType == null) {
            logger.error("RequestBody is empty");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(newType.getDeletedAt() != null) {
            logger.error("RequestBody Type: {} marked as deleted", newType.getType());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Type type = typeRepository.findById(newType.getId()).orElseThrow(NotFoundException::new);
        if(type.getDeletedAt() != null) {
            logger.info("Type {} in database marked as deleted", type.getType());
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        typeRepository.updateType(newType.getType(), newType.getFabrics(), new Date(), newType.getId());
        logger.info("Type {} updated in database", type.getType());
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