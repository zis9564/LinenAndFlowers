package com.geleigeit.LinenAndFlowers.controller.interfaceControllers;

import com.geleigeit.LinenAndFlowers.entity.BaseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

public interface GetMethodsController<E extends BaseEntity> {

    @Transactional
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    E getOne(@PathVariable("id") long id);

    @Transactional
    @GetMapping
    Set<E> getAll();
}
