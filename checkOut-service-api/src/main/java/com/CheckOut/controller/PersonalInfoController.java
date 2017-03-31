package com.CheckOut.controller;

import com.CheckOut.model.CreditRatingTypes;
import com.CheckOut.model.Items;
import com.CheckOut.model.PersonalInformation;
import com.CheckOut.model.Order;
import com.CheckOut.repository.PersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by kvajramani on 28-03-2017.
 */
@RestController
@RequestMapping(value = "/checkout", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonalInfoController {

    @Autowired
    protected PersonalInfoRepository personalInfoRepository;

    @RequestMapping(value = "/personalinfo")
    public void createOrder(@RequestBody PersonalInformation personalInfo)
    {
        Order order = new Order();
        order.setId(personalInfo.getOrderId());
        order.setFirstName(personalInfo.getFirstName());
        order.setLastName(personalInfo.getLastName());
        order.setEmail(personalInfo.getEmail());
        order.setPhone(personalInfo.getPhone());
        order.setCurrentCarrier(personalInfo.getCurrentCarrier());

        /*Order order1 = new Order();
        order1.setId("3");
        order1.setFirstName("MyName1");
        order1.setLastName("LastName1");
        order1.setEmail("vajramani1@gmail.com");
        order1.setPhone("1234567891");
        order1.setCurrentCarrier("ydfgdjhkgdg1");*/

        personalInfoRepository.save(order);

    }

    @RequestMapping(value = "/personalinfo/{id}")
    public Order getOrderByIdValue(@PathVariable("id") String id)
    {
        return personalInfoRepository.getOrderById(id);
    }

    @RequestMapping(value="/creditratingtypes",method = RequestMethod.GET)
    public @ResponseBody
    CreditRatingTypes create() {
        CreditRatingTypes creditRatingTypes = new CreditRatingTypes();
        creditRatingTypes.setError("0");
        creditRatingTypes.setMessage("Successfully Got the Credit Score Range Type from the database");
        ArrayList<Items> itemsCollection = new ArrayList<Items>();
        Items items1 = new Items();
        items1.setId("AWESOME-CREDIT");
        Items items2 = new Items();
        items2.setId("AVERAGE-CREDIT");

        Items items3 = new Items();
        items3.setId("GOOD-CREDIT");
        itemsCollection.add(items1);
        itemsCollection.add(items2);
        itemsCollection.add(items3);
        creditRatingTypes.setItems(itemsCollection);
        return creditRatingTypes;

    }

}
