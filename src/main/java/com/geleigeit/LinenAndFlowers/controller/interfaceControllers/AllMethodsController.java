package com.geleigeit.LinenAndFlowers.controller.interfaceControllers;

import com.geleigeit.LinenAndFlowers.entity.BaseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface AllMethodsController<E extends BaseEntity> extends GetMethodsController<E> {

    @Transactional
    @PostMapping
    void post(@RequestBody @Valid E e);

    @Transactional
    @PutMapping
    E put(@RequestBody @Valid E e);

    @Transactional
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    void remove(@PathVariable("id") long id);
}