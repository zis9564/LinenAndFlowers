package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Thickness;
import com.geleigeit.LinenAndFlowers.repository.ThicknessRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThicknessService extends AbstractService<Thickness, ThicknessRepository> {

    @Autowired
    public ThicknessService(ThicknessRepository thicknessRepository) {
        super(thicknessRepository);
    }
}