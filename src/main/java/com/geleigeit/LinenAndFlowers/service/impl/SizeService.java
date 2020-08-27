package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Size;
import com.geleigeit.LinenAndFlowers.repository.SizeRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class SizeService extends AbstractService<Size, SizeRepository> {

    public SizeService(SizeRepository repository) {
        super(repository);
    }
    Logger logger = LogManager.getLogger(ColourService.class);

    @Override
    public Size update(Size newSize) {
        Size size = getOne(newSize.getId());
        size.setSize(newSize.getSize());
        size.setChest(newSize.getChest());
        size.setWaist(newSize.getWaist());
        size.setHips(newSize.getHips());
        size.setHeight(newSize.getHeight());
        size.setFabricCounts((newSize.getFabricCounts()));
        size.setItems(newSize.getItems());
        logger.debug("size {} has updated", size.hashCode());
        return repository.save(size);
    }
}
