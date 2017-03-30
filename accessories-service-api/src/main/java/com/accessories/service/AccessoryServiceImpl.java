package com.accessories.service;

import com.accessories.model.Accessory;
import com.accessories.repository.AccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessoryServiceImpl implements AccessoryService {

    @Autowired
    AccessoryRepository repository;

    public List<Accessory> getAllAccessories()
    {
        List<Accessory> accessories = null;
        accessories = repository.findAll();
        return accessories;

    }

    public Accessory getAccessoryDetails(Long id)
    {
        Accessory accessory = null;
        accessory = repository.findById(id);
        return accessory;
    }

   public List<Accessory> getAllAccessoriesMatchingSku(String skuid)
   {
       List<Accessory> accessories = null;
       accessories = repository.findBySkuid(skuid);
       return accessories;
   }

    public List<Accessory> searchAccessories(String keyword)
    {
        List<Accessory> accessories = null;
        //accessories = repository.searchAccessoriesByKeyword(keyword);
        return accessories;
    }
}
