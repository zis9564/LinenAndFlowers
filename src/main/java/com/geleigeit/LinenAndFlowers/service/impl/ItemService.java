package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Item;
import com.geleigeit.LinenAndFlowers.repository.ItemRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends AbstractService<Item, ItemRepository> {

    @Autowired
    public ItemService(ItemRepository repository) {
        super(repository);
    }
    Logger logger = LogManager.getLogger(ItemService.class);

    @Override
    public Item update(Item newItem) {
        Item item = getOne(newItem.getId());
        item.setFabric(newItem.getFabric());
        item.setItemName(newItem.getItemName());
        item.setSize(newItem.getSize());
        logger.debug("item {} has updated", item.hashCode());
        return repository.save(item);
    }
}
