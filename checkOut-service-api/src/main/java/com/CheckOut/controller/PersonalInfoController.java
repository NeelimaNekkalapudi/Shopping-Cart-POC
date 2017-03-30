package com.CheckOut.controller;

import com.CheckOut.model.PersonalInformation;
import com.CheckOut.model.Order;
import com.CheckOut.repository.PersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
