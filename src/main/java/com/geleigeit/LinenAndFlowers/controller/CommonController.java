package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.entity.BaseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

public interface CommonController<E extends BaseEntity> {

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
    Set<E> getAll();
}