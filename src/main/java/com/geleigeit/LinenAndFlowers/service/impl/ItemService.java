package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.calculator.FabricLengthCalculator;
import com.geleigeit.LinenAndFlowers.entity.tables.Item;
import com.geleigeit.LinenAndFlowers.exception.NegativeValueException;
import com.geleigeit.LinenAndFlowers.repository.ItemRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ItemService extends AbstractService<Item, ItemRepository> {

    private final FabricLengthCalculator fabricLengthCalculator;

    @Autowired
    public ItemService(ItemRepository repository,
                       FabricLengthCalculator fabricLengthCalculator) {
        super(repository);
        this.fabricLengthCalculator = fabricLengthCalculator;

    }

    @Override
    public void addOne(Item item) {
        try {
            repository.save(fabricLengthCalculator.calculateFabricLength(item));
        } catch (NegativeValueException e) {
            throw new ResponseStatusException(
                    HttpStatus.I_AM_A_TEAPOT, "not enough fabric", e);
        }
    }
}