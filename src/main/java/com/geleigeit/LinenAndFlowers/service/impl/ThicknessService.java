package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Thickness;
import com.geleigeit.LinenAndFlowers.repository.ThicknessRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThicknessService extends AbstractService<Thickness, ThicknessRepository> {

    @Autowired
    public ThicknessService(ThicknessRepository thicknessRepository) {
        super(thicknessRepository);
    }
    Logger logger = LogManager.getLogger(ThicknessService.class);

    @Override
    public Thickness update(Thickness newThickness) {
        Thickness thickness = getOne(newThickness.getId());
        thickness.setThickness(newThickness.getThickness());
        thickness.setFabrics(newThickness.getFabrics());
        logger.debug("thickness {} has updated", thickness.hashCode());
        return repository.save(thickness);
    }
}