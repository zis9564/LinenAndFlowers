package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.Colour;
import java.util.List;

public interface ColourService {

    void addColour(Colour colour);
    Colour deleteColour(long id);
    Colour updateColour(Colour newColour);
    Colour getOne(long id);
    List<Colour> getAll();
}
