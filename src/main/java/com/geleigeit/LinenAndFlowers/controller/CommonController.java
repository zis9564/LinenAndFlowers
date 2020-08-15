package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.entity.AbstractEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CommonController<E extends AbstractEntity> {

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    E getOne(@PathVariable("id") long id);

    @PostMapping
    void post(@RequestBody E e, BindingResult result);

    @PutMapping
    E put(@RequestBody E e);

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    void remove(@PathVariable("id") long id);

    @GetMapping
    List<E> getAll();
}