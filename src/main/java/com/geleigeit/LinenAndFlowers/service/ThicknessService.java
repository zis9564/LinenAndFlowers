package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.Fabric;
import com.geleigeit.LinenAndFlowers.entity.Thickness;
import java.util.List;

public interface ThicknessService {

    void addThickness(Thickness thickness);
    void deleteThickness(long id);
    void updateThickness(int thickness, long id);
    Thickness getOne(long id);
    List<Thickness> getAll();
}
