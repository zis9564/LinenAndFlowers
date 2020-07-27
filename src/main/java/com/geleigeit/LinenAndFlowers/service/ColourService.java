package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.Colour;
import java.util.List;

public interface ColourService {

    void addColour(Colour colour);
    void deleteColour(long id);
    void updateColour(String name, long id);
    Colour getOne(long id);
    List<Colour> getAll();
}
