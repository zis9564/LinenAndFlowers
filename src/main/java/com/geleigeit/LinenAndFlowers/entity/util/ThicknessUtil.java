package com.geleigeit.LinenAndFlowers.entity.util;

import com.geleigeit.LinenAndFlowers.entity.Thickness;

public class ThicknessUtil {

    public static Thickness createThickness(int thick) {
        Thickness thickness = new Thickness();
        thickness.setThickness(thick);
        return thickness;
    }
}
