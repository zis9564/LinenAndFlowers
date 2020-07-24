package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.Fabric;
import java.util.List;

public interface FabricService {

    void addFabric(Fabric fabric);
    void deleteFabric(long id);
    void updateFabricLength(int newLength, long id);
    Fabric getOne(long id);
    List<Fabric> getAllFabrics();
}