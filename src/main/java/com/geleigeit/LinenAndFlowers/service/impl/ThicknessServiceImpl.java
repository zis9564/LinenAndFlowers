package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.Thickness;
import com.geleigeit.LinenAndFlowers.repository.ThicknessRepository;
import com.geleigeit.LinenAndFlowers.service.ThicknessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ThicknessServiceImpl implements ThicknessService{

    @Autowired
    ThicknessRepository thicknessRepository;

    @Override
    @Transactional
    public void addThickness(Thickness thickness) {
        thicknessRepository.save(thickness);
    }

    @Override
    @Transactional
    public void deleteThickness(long id) {
        thicknessRepository.deleteThickness(id);
    }

    @Override
    @Transactional
    public void updateThickness(int thickness, long id) {
        thicknessRepository.updateThickness(thickness, id);
    }

    @Override
    @Transactional
    public Thickness getOne(long id) {
        Optional<Thickness> thickness = thicknessRepository.findById(id);
        if(thickness.isPresent()) {
            try {
                return thickness.get();
            } catch (NullPointerException e) {
                System.out.println("thickness doesn't exist");
            }
        }
        return null;
    }

    @Override
    @Transactional
    public List<Thickness> getAll() {
        return thicknessRepository.findAllByExistTrue();
    }
}