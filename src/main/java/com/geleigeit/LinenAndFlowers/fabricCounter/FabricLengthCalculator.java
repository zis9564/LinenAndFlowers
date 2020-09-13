package com.geleigeit.LinenAndFlowers.fabricCounter;

import com.geleigeit.LinenAndFlowers.entity.tables.Fabric;
import com.geleigeit.LinenAndFlowers.entity.tables.Item;
import com.geleigeit.LinenAndFlowers.exception.NegativeValueException;
import com.geleigeit.LinenAndFlowers.service.impl.FabricCountService;
import com.geleigeit.LinenAndFlowers.service.impl.FabricService;
import com.geleigeit.LinenAndFlowers.service.impl.ProductService;
import com.geleigeit.LinenAndFlowers.service.impl.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FabricLengthCalculator {

    private final ProductService productService;
    private final SizeService sizeService;
    private final FabricService fabricService;
    private final FabricCountService fabricCountService;

    @Autowired
    public FabricLengthCalculator(ProductService productService,
                                  SizeService sizeService,
                                  FabricService fabricService,
                                  FabricCountService fabricCountService) {
        this.productService = productService;
        this.sizeService = sizeService;
        this.fabricService = fabricService;
        this.fabricCountService = fabricCountService;
    }

    public Item calculateFabricLength (Item item) {
        String vendorCode = productService.getOne(item.getProduct().getId()).getVendorCode();
        String size = sizeService.getOne(item.getSize().getId()).getSize();
        Fabric fabric = fabricService.getOne(item.getFabric().getId());
        int expectedFabricConsumption = fabricCountService.getLengthByVendorCodeAndSize(vendorCode, size);

        item.setFabric(calculator(fabric, expectedFabricConsumption));
        return item;
    }

    private Fabric calculator(Fabric fabric, int expectedFabricConsumption) {
        int newFabricLength = fabric.getLength() - expectedFabricConsumption;
        if(newFabricLength < 1) {
            throw new NegativeValueException();
        }
            fabric.setLength(newFabricLength);
            return fabric;
    }
}