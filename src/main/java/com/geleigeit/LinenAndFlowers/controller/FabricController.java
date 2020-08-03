package com.geleigeit.LinenAndFlowers.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.geleigeit.LinenAndFlowers.entity.Fabric;
import com.geleigeit.LinenAndFlowers.entity.View;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.FabricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("fabric")
public class FabricController {

    private final FabricRepository fabricRepository;

    @Autowired
    public FabricController(FabricRepository fabricRepository) {
        this.fabricRepository = fabricRepository;
    }

    @GetMapping
    @JsonView(View.fullEntity.class)
    public List<Fabric> getAll() {
        return fabricRepository.findAllByDeletedAtIsNull();
    }

    @GetMapping("{id}")
    @JsonView(View.fullEntity.class)
    public Fabric getOne(@PathVariable Long id) {
        return fabricRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Fabric add(@RequestBody Fabric newFabric) {
        return fabricRepository.save(newFabric);
    }

    @PutMapping("{id}")
    public Fabric update(@RequestBody Fabric newFabric, @PathVariable Long id) {
        Date update = new Date();
        return fabricRepository.findById(id)
                .map(fabric -> {
                    fabric.setLength(newFabric.getLength());
                    fabric.setColour(newFabric.getColour());
                    fabric.setType(newFabric.getType());
                    fabric.setThickness(newFabric.getThickness());
                    fabric.setUpdatedAt(update);
                    return fabricRepository.save(fabric);
                })
                .orElseGet(() -> add(newFabric));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        Date delete = new Date();
        fabricRepository.deleteFabric(delete, id);
    }
}
