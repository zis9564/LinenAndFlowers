package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.Fabric;

import java.util.Date;
import java.util.List;

public interface FabricService {

    void addFabric(Fabric fabric);
    Fabric deleteFabric(Date delete, long id);
    void updateFabric(int newLength, long id);
    Fabric getOne(long id);
    List<Fabric> getAllFabrics();
}