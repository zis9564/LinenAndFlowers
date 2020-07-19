package com.geleigeit.LinenAndFlowers.entity.util;

import com.geleigeit.LinenAndFlowers.entity.Fabric;

public class FabricUtil {

    public static Fabric createFabric() {
        Fabric fabric = new Fabric();
        fabric.setLength(6000);
        return fabric;
    }
}