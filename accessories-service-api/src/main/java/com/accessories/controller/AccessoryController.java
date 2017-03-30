package com.accessories.controller;

import com.accessories.model.Accessory;
import com.accessories.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class AccessoryController {

    @Autowired
    AccessoryService service;

    @RequestMapping("/accessories")
    public List<Accessory> getAllAccessories()
    {
        List<Accessory> accessories = null;
        accessories = service.getAllAccessories();
        return accessories;
    }

    @RequestMapping("/accessories/details/{id}")
    public Accessory getAccessoryDetails(@PathVariable("id") Long id)
    {
        Accessory accessory = null;
        accessory = service.getAccessoryDetails(id);
        return accessory;
    }

    @RequestMapping("/accessories/search/downstream/{sku}")
    public List<Accessory> getAllAccessoriesMatchingSku(@PathVariable("sku") String sku)
    {
        List<Accessory> accessories = null;
        accessories = service.getAllAccessoriesMatchingSku(sku);
        return accessories;
    }

    @RequestMapping("/accessories/search/{keyword}")
    public List<Accessory> searchAccessories(@PathVariable("keyword") String keyword)
    {
        List<Accessory> accessories = null;
        accessories = service.searchAccessories(keyword);
        return accessories;
    }
}
