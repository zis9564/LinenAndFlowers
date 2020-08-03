package com.geleigeit.LinenAndFlowers.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.geleigeit.LinenAndFlowers.entity.Thickness;
import com.geleigeit.LinenAndFlowers.entity.View;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.ThicknessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("thickness")
public class ThicknessController {

    private final ThicknessRepository thicknessRepository;

    @Autowired
    public ThicknessController(ThicknessRepository thicknessRepository) {
        this.thicknessRepository = thicknessRepository;
    }

    @GetMapping
    @JsonView(View.idName.class)
    public List<Thickness> getAll() {
        return thicknessRepository.findAllByDeletedAtIsNull();
    }

    @GetMapping("{id}")
    @JsonView(View.idName.class)
    public Thickness getOne(@PathVariable Long id) {
        return thicknessRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Thickness add(@RequestParam int thick) {
        Thickness thickness = new Thickness();
        thickness.setThickness(thick);
        return thicknessRepository.save(thickness);
    }

    @PutMapping("{id}")
    public Thickness update(@RequestBody Thickness newThickness, @PathVariable Long id) {
        Date update = new Date();
        return thicknessRepository.findById(id)
                .map(thickness -> {
                    thickness.setThickness(newThickness.getThickness());
                    thickness.setUpdatedAt(update);
                    return thicknessRepository.save(thickness);
                })
                .orElseThrow(NotFoundException::new);
    }

    @DeleteMapping("{id}")
    public Thickness delete(@PathVariable Long id) {
        Date delete = new Date();
        return thicknessRepository.findById(id)
                .map(thickness -> {
                    thickness.setDeletedAt(delete);
                    return thicknessRepository.save(thickness);
                })
                .orElseThrow(NotFoundException::new);
    }
}