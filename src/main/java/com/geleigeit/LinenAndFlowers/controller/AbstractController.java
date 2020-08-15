package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.Validator.AbstractValidator;
import com.geleigeit.LinenAndFlowers.entity.AbstractEntity;
import com.geleigeit.LinenAndFlowers.config.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.CommonRepository;
import com.geleigeit.LinenAndFlowers.service.CommonService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.validation.Valid;
import java.util.List;

public abstract class AbstractController<E extends AbstractEntity, S extends CommonService<E>, V extends AbstractValidator<E>> implements CommonController<E> {

    private final S service;

    private final V validator;

    private static final Logger logger = LogManager.getLogger(AbstractController.class);

    protected AbstractController(S service, V validator) {
        this.service = service;
        this.validator = validator;
    }

    @Override
    public E getOne(long id) {
        final E e;
        try {
            e = service.getOne(id);
        } catch (NotFoundException exception) {
            logger.error("Entity id:{} not found", id);
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "not found", exception);
        }
        return e;
    }

    @Override
    public void post(@Validated @RequestBody E e, BindingResult result) {
        validator.validate(e, result);
        if (result.hasErrors()) {
            FieldError errors = result.getFieldError();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.getDefaultMessage());
        }
        service.addOne(e);
    }

    @Override
    public E put(@RequestBody @Valid E e) {
        try {
            return service.update(e);
        } catch (NotFoundException exception) {
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
        } catch (IllegalArgumentException exception) {
            logger.error("Entity id:{} not found", id);
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Entity with given id doesn't exist", exception);
        }
    }

    @Override
    public List<E> getAll() {
        try {
            return service.getAll();
        } catch (NotFoundException exception) {
            logger.error("no one entity found");
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "no one entity found", exception);
        }
    }
}