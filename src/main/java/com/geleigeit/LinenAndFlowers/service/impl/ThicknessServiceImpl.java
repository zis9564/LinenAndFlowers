package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.Thickness;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.ThicknessRepository;
import com.geleigeit.LinenAndFlowers.service.ThicknessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ThicknessServiceImpl implements ThicknessService{

    private final ThicknessRepository thicknessRepository;

    @Autowired
    public ThicknessServiceImpl(ThicknessRepository thicknessRepository) {
        this.thicknessRepository = thicknessRepository;
    }

    @Override
    @Transactional
    public Thickness addThickness(Thickness thickness) {
        if(thickness == null || thickness.getThickness() == 0) throw  new NullPointerException();
        return thicknessRepository.save(thickness);
    }

    @Override
    @Transactional
    public Thickness deleteThickness(long id) {
        Thickness thickness = thicknessRepository.findById(id).orElseThrow(NotFoundException::new);
        if(thickness.getDeletedAt() != null) throw new NotFoundException();
        thickness.setDeletedAt(new Date());
        return thicknessRepository.save(thickness);
    }

    @Override
    @Transactional
    public Thickness updateThickness(Thickness newThickness) {
        if(newThickness == null || newThickness.getThickness() == 0) throw new RuntimeException();
        Thickness thickness = thicknessRepository.findById(newThickness.getId()).orElseThrow(NotFoundException::new);
        if(thickness.getDeletedAt() != null) throw new NotFoundException();
        thickness.setThickness(newThickness.getThickness());
        thickness.setFabrics(newThickness.getFabrics());
        thickness.setUpdatedAt(new Date());
        return thicknessRepository.save(thickness);
    }

    @Override
    @Transactional
    public Thickness getOne(long id) {
        return thicknessRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    @Transactional
    public List<Thickness> getAll() {
        List<Thickness> thicknessList = thicknessRepository.findAllByDeletedAtIsNull();
        if(thicknessList.isEmpty()) throw new NotFoundException();
        return thicknessList;
    }
}