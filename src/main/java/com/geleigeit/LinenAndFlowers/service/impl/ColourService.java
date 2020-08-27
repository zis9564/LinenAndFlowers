package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Colour;
import com.geleigeit.LinenAndFlowers.repository.ColourRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColourService extends AbstractService<Colour, ColourRepository> {

    @Autowired
    public ColourService(ColourRepository colourRepository) {
        super(colourRepository);
    }
    Logger logger = LogManager.getLogger(ColourService.class);

    @Override
    public Colour update(Colour newColour) {
        Colour colour = getOne(newColour.getId());
        colour.setColour(newColour.getColour());
        colour.setFabrics(newColour.getFabrics());
        logger.debug("colour {} has updated", colour.hashCode());
        return repository.save(colour);
    }
}