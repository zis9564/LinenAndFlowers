package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.entity.BaseEntity;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.service.CommonService;
import com.geleigeit.LinenAndFlowers.validator.AbstractValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

public abstract class AbstractController<E extends BaseEntity,
        S extends CommonService<E>,
        V extends AbstractValidator<E>>
        implements CommonController<E> {

    private final S service;

    private static final Logger logger = LogManager.getLogger(AbstractController.class);

    protected AbstractController(S service, V validator) {
        this.service = service;
    }

    @Override
    public E getOne(long id) {
        final E e;
        try {
            e = service.getOne(id);
        } catch (NullPointerException exception) {
            logger.error("{} entity with id:{} not found", this, id);
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "not found", exception);
        }
        return e;
    }

    @Override
    public void post(E e) {
        try {
            service.addOne(e);
        } catch (NullPointerException exception) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "given entity is already exist", exception);
        }
    }

    @Override
    public E put(E e) {
        try {
            return service.update(e);
        } catch (NullPointerException exception) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "some of fields doesn't match", exception);
        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "given entity is null", exception);
        }
    }

    @Override
    public void remove(long id) {
        try {
            service.delete(id);
            logger.info("Entity {} id {} deleted", this, id);
        } catch (EmptyResultDataAccessException exception) {
            logger.error("Controller {} Entity id:{} not found", this, id);
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Entity with given id doesn't exist", exception);
        }
    }

    @Override
    public Set<E> getAll() {
        try {
            return service.getAll();
        } catch (NotFoundException exception) {
            logger.error("no one entity found");
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "no one entity found", exception);
        }
    }
}