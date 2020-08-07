package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.Thickness;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.ThicknessRepository;
import com.geleigeit.LinenAndFlowers.service.ThicknessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        if(thickness == null || thickness.getDeletedAt() != null) throw  new NotFoundException();
        return thicknessRepository.save(thickness);
    }

    @Override
    @Transactional
    public Thickness getOne(long id) {
        return thicknessRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}