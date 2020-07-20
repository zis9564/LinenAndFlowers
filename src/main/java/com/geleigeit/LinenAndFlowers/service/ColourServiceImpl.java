package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.Colour;
import com.geleigeit.LinenAndFlowers.repository.ColourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ColourServiceImpl implements ColourService{

    @Autowired
    private ColourRepository colourRepository;

//    @Autowired
//    public ColourServiceImpl(ColourRepository colourRepository) {
//        this.colourRepository = colourRepository;
//    }

    @Transactional
    @Override
    public void addColour(Colour colour) {
        colourRepository.saveAndFlush(colour);
    }
}
