package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.Thickness;
import java.util.List;

public interface ThicknessService {

    Thickness addThickness(Thickness thickness);
//    Thickness deleteThickness(long id);
//    Thickness updateThickness(Thickness newThickness);
    Thickness getOne(long id);
//    List<Thickness> getAll();
}
