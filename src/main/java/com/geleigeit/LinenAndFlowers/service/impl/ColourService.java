package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Colour;
import com.geleigeit.LinenAndFlowers.repository.ColourRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColourService extends AbstractService<Colour, ColourRepository> {

    @Autowired
    public ColourService(ColourRepository colourRepository) {
        super(colourRepository);
    }

}