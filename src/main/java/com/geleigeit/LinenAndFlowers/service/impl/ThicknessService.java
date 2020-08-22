package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.Thickness;
import com.geleigeit.LinenAndFlowers.repository.ThicknessRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class ThicknessService extends AbstractService<Thickness, ThicknessRepository> {

    public ThicknessService(ThicknessRepository thicknessRepository) {
        super(thicknessRepository);
    }

    @Override
    public Thickness update(Thickness newThickness) {
        Thickness thickness = getOne(newThickness.getId());
        thickness.setThickness(newThickness.getThickness());
        thickness.setFabrics(newThickness.getFabrics());
        return repository.save(thickness);
    }
}