package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.entity.AbstractEntity;
import com.geleigeit.LinenAndFlowers.config.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.service.CommonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public abstract class AbstractController
        <E extends AbstractEntity, S extends CommonService<E>>
        implements CommonController<E> {

    private final S service;

    protected AbstractController(S service) {
        this.service = service;
    }

    @Override
    public E getOne(long id) {
        final E e;
        try {
            e = service.getOne(id);
        } catch (NotFoundException exception) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "some text", exception);
        }
        return e;
    }

    @Override
    public void post(@RequestBody E e) {
        try {
            service.addOne(e);
        } catch (NotFoundException exception) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "some text2", exception);
        }
    }

    @Override
    public E put(@RequestBody E e) {
        try {
            return service.update(e);
        } catch (NotFoundException exception) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "some text3", exception);
        }
    }

    @Override
    public void remove(long id) {
        try {
            service.delete(id);
        } catch (NotFoundException exception) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "some text4", exception);
        }
    }

    @Override
    public List<E> getAll() {
        try {
            return service.getAll();
        } catch (NotFoundException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "some text5", exception);
        }
    }
}