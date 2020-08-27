package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.ItemName;
import com.geleigeit.LinenAndFlowers.repository.ItemNameRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemNameService extends AbstractService<ItemName, ItemNameRepository> {

    @Autowired
    public ItemNameService(ItemNameRepository repository) {
        super(repository);
    }
    Logger logger = LogManager.getLogger(FabricCountService.class);

    @Override
    public ItemName update(ItemName newItemName) {
        ItemName itemName = getOne(newItemName.getId());
        itemName.setName(newItemName.getName());
        itemName.setVendorCode(newItemName.getVendorCode());
        itemName.setFabricCountList(newItemName.getFabricCountList());
        itemName.setItems(newItemName.getItems());
        logger.debug("item_name {} has updated", itemName.hashCode());
        return repository.save(itemName);
    }
}
