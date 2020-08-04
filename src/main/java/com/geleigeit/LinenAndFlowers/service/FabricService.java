package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.Fabric;
import java.util.List;

public interface FabricService {

    Fabric addFabric(Fabric fabric);
    Fabric deleteFabric(long id);
    Fabric updateFabric(Fabric newFabric);
    Fabric getOne(long id);
    List<Fabric> getAllFabrics();
}