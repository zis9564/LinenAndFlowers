package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Colour;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.ColourRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColourService extends AbstractService<Colour, ColourRepository> {

    private final String doesntExist = "colour id {} doesn't exist";
    private final String updated = "colour id {} has updated";
    private static final Logger logger = LogManager.getLogger(ColourService.class);

    @Autowired
    public ColourService(ColourRepository colourRepository) {
        super(colourRepository);
    }

    @Override
    public Colour update(Colour newColour) {
        try {
            Colour colour = repository.findById(newColour.getId()).orElseThrow(NotFoundException::new);
            colour.setColour(newColour.getColour());
        } catch (NullPointerException e) {
            e.printStackTrace();
            logger.error(doesntExist, newColour.getId());
        }
        logger.info(updated, newColour.getId());
        return repository.save(newColour);
    }
}