package com.CheckOut.controller;

import com.CheckOut.model.*;
import com.CheckOut.repository.PersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.lang.Iterable;
import java.util.List;

/**
 * Created by kvajramani on 28-03-2017.
 */
@RestController
@RequestMapping(value = "/checkout", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:8080")
public class PersonalInfoController {

    @Autowired
    protected PersonalInfoRepository personalInfoRepository;

    @Autowired
    DiscoveryClient client;

    @RequestMapping(value = "/personalinfo" ,method = RequestMethod.POST)
    public PersonalInformationResponse createOrder(@RequestBody PersonalInformation personalInfo)
    {
        Order order = new Order();
        Long count = personalInfoRepository.count();
        if(count>0)
        {
            order.setId(String.valueOf(count+1));
        }
        else
        {
            order.setId(String.valueOf(1));
        }
        order.setFirstname(personalInfo.getFirstname());
        order.setLastname(personalInfo.getLastname());
        order.setEmail(personalInfo.getEmail());
        order.setPhone(personalInfo.getPhone());
        order.setCurrentcarrier(personalInfo.getCurrentcarrier());
        order.setCreatedAt(formatDate());
        order.setUpdatedAt(formatDate());
        order.setUsername(personalInfo.getUsername());
        order.setProducts(personalInfo.getProductsList());
        order.setAccessories(personalInfo.getAccessoriesList());

        personalInfoRepository.save(order);

        PersonalInformationResponse personalInformationResponse = new PersonalInformationResponse();

        ArrayList<OrderDetails> orderDetails = new ArrayList();
        OrderDetails orderDetails1 = new OrderDetails();
        orderDetails.add(orderDetails1);
        personalInformationResponse.setOrderDetails(orderDetails);
        return personalInformationResponse;
    }

    @RequestMapping
    private Iterable<Order> orders()
    {
        return personalInfoRepository.findAll();
    }

    @RequestMapping(value = "/personalinfo/{id}")
     public Order getOrderByIdValue(@PathVariable("id") String id)
    {
        return personalInfoRepository.getOrderById(id);
    }

    @RequestMapping(value = "/orders/{username}")
    public Iterable<Order> getOrderByUserNameValue(@PathVariable("username") String username)
    {
        return personalInfoRepository.getOrderByUsername(username);
    }

    @RequestMapping(value="/creditratingtypes",method = RequestMethod.GET)
    public CreditRatingTypes create() {
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

    @RequestMapping("/instance")
    public String getInstanceDetails() {
        ServiceInstance localInstance = client.getLocalServiceInstance();
        return "Instance Details: "+ localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort();
    }
    public String formatDate()
    {
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        return reportDate;
    }
}
