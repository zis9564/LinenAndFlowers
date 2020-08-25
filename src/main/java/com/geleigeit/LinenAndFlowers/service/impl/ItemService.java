package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.Item;
import com.geleigeit.LinenAndFlowers.repository.ItemRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends AbstractService<Item, ItemRepository> {

    @Autowired
    public ItemService(ItemRepository repository) {
        super(repository);
    }

    @Override
    public Item update(Item newItem) {
        Item item = getOne(newItem.getId());
        item.setFabric(newItem.getFabric());
        item.setProduct(newItem.getProduct());
        item.setSize(newItem.getSize());
        return repository.save(item);
    }
}
