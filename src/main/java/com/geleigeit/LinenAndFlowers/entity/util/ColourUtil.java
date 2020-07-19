package com.geleigeit.LinenAndFlowers.entity.util;

import com.geleigeit.LinenAndFlowers.entity.Colour;

public class ColourUtil {

    public static Colour createColour(String name) {
        Colour colour = new Colour();
        colour.setColour(name);
        return colour;
    }
}