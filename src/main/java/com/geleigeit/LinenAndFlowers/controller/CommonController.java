package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.entity.AbstractEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface CommonController<E extends AbstractEntity> {

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @Transactional
    E getOne(@PathVariable("id") long id);

    @PostMapping
    @Transactional
    void post(@RequestBody @Valid E e);

    @PutMapping
    @Transactional
    E put(@RequestBody @Valid E e);

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @Transactional
    void remove(@PathVariable("id") long id);

    @GetMapping
    @Transactional
    List<E> getAll();
}