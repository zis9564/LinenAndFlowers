package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.Colour;
import com.geleigeit.LinenAndFlowers.repository.ColourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColourService extends AbstractService<Colour, ColourRepository> {

    @Autowired
    public ColourService(ColourRepository colourRepository) {
        super(colourRepository);
    }

    @Override
    public Colour update(Colour newColour) {
        Colour colour = getOne(newColour.getId());
        colour.setColour(newColour.getColour());
        colour.setFabrics(newColour.getFabrics());
        return repository.save(colour);
    }
}