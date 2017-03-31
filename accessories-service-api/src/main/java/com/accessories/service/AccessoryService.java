package com.accessories.service;

import com.accessories.model.Accessory;

import java.util.List;


public interface AccessoryService {

    List<Accessory> getAllAccessories();

    Accessory getAccessoryDetails(Long id);

    List<Accessory> getAllAccessoriesMatchingSku(String sku);

    List<Accessory> searchAccessories(String keyword);

    void saveNewAccessory(Accessory accessory);

}
