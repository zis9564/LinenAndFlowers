package com.geleigeit.LinenAndFlowers.controller;

import com.geleigeit.LinenAndFlowers.entity.AbstractEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface CommonController<E extends AbstractEntity> {

    @PreAuthorize("hasAuthority('developers:read')")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @Transactional
    E getOne(@PathVariable("id") long id);

    @PreAuthorize("hasAuthority('developers:write')")
    @PostMapping
    @Transactional
    void post(@RequestBody @Valid E e);

    @PreAuthorize("hasAuthority('developers:write')")
    @PutMapping
    @Transactional
    E put(@RequestBody @Valid E e);

    @PreAuthorize("hasAuthority('developers:write')")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @Transactional
    void remove(@PathVariable("id") long id);

    @PreAuthorize("hasAuthority('developers:read')")
    @GetMapping
    @Transactional
    List<E> getAll();
}