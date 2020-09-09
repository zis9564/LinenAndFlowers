package com.geleigeit.LinenAndFlowers.repository;

import com.geleigeit.LinenAndFlowers.entity.tables.FabricCount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricCountRepository extends CrudRepository<FabricCount, Long> {

    FabricCount findByVendorCodeAndSize(String vendorCode, String size);
}
