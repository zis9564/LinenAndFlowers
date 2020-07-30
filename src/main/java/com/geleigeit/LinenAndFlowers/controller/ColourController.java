package com.geleigeit.LinenAndFlowers.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.geleigeit.LinenAndFlowers.entity.Colour;
import com.geleigeit.LinenAndFlowers.entity.View;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.ColourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("colour")
public class ColourController {

    private final ColourRepository colourRepository;

    @Autowired
    public ColourController(ColourRepository colourRepository) {
        this.colourRepository = colourRepository;
    }

    @GetMapping
    @JsonView(View.idName.class)
    public List<Colour> getAll() {
        return colourRepository.findAllByDeletedAtIsNull();
    }

    @GetMapping("{id}")
    @JsonView(View.idName.class)
    public Colour getOne(@PathVariable Long id) {
        return colourRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping()
    public Colour add(@RequestParam String name) {
        Colour colour = new Colour();
        colour.setColour(name);
        return colourRepository.save(colour);
    }

    @PutMapping("{id}")
    public Colour update(@RequestBody Colour newColour, @PathVariable Long id) {
        Date update = new Date();
        return colourRepository.findById(id)
                .map(colour -> {
                    colour.setColour(newColour.getColour());
                    colour.setUpdatedAt(update);
                    return colourRepository.save(colour);
                })
                .orElseGet(() -> add(newColour.getColour()));
    }

    @DeleteMapping("{id}")
    public Colour delete(@PathVariable Long id) {
        Date delete = new Date();
        return colourRepository.findById(id)
                .map(colour -> {
                    colour.setDeletedAt(delete);
                    return colourRepository.save(colour);
        })
        .orElseThrow(NotFoundException::new);
    }
}