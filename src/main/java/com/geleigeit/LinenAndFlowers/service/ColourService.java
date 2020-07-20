package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.Colour;
import org.springframework.stereotype.Service;

@Service
public interface ColourService {

    void addColour(Colour colour);
}
