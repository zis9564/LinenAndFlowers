package com.geleigeit.LinenAndFlowers.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.geleigeit.LinenAndFlowers.entity.Type;
import com.geleigeit.LinenAndFlowers.entity.View;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("type")
public class TypeController {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @GetMapping
    @JsonView(View.idName.class)
    public List<Type> getAll() {
        return typeRepository.findAllByDeletedAtIsNull();
    }

    @GetMapping("{id}")
    @JsonView(View.idName.class)
    public Type getOne(@PathVariable Long id) {
        return typeRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Type add(@RequestParam String name) {
        Type type = new Type();
        type.setType(name);
        return typeRepository.save(type);
    }

    @PutMapping("{id}")
    public Type update(@RequestBody Type newType, @PathVariable Long id) {
        Date update = new Date();
        return typeRepository.findById(id)
                .map(type -> {
                    type.setUpdatedAt(update);
                    type.setType(newType.getType());
                    return typeRepository.save(type);
                })
                .orElseGet(() -> add(newType.getType()));
    }

    @DeleteMapping("{id}")
    public Type delete(@PathVariable Long id) {
        Date delete = new Date();
        return typeRepository.findById(id)
                .map(type -> {
                    type.setDeletedAt(delete);
                    return typeRepository.save(type);
                })
                .orElseThrow(NotFoundException::new);
    }
}