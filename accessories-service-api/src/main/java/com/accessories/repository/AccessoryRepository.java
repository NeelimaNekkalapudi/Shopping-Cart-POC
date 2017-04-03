package com.accessories.repository;

import com.accessories.model.Accessory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccessoryRepository extends CrudRepository<Accessory,Long>
{
    List<Accessory> findAll();

    Accessory findById(Long id);

    List<Accessory> findBySkuid(String skuid);

    List<Accessory> findByEpidIgnoreCaseContaining(String epid);

   // List<Accessory> searchAccessoriesByKeyword(String sku);

}
