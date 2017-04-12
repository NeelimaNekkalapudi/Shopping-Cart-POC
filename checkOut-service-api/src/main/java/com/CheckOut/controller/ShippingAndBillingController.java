package com.CheckOut.controller;

/**
 * Created by kvajramani on 28-03-2017.
 */

import com.CheckOut.model.*;
import com.CheckOut.repository.PersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/checkout", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:8080")
/*@Profile("qat")*/
public class ShippingAndBillingController {


    @Autowired
    protected PersonalInfoRepository shippingAndBillingRepository;

    @RequestMapping(value ="/billandship" , method = RequestMethod.PATCH)
    public PersonalInformationResponse updateOrder(@RequestBody AddressDetails address) {

        Order billingOrder = shippingAndBillingRepository.getOrderById(String.valueOf(shippingAndBillingRepository.count()));
        billingOrder.setBilladdress1(address.getBilladdress1());
        billingOrder.setBilladdress2(address.getBilladdress2());
        billingOrder.setBillcity(address.getBillcity());
        billingOrder.setBillstate(address.getBillstate());
        billingOrder.setBillzip(address.getBillzip());
        billingOrder.setShipaddress1(address.getShipaddress1());
        billingOrder.setShipaddress2(address.getShipaddress2());
        billingOrder.setShipcity(address.getShipcity());
        billingOrder.setShipstate(address.getShipstate());
        billingOrder.setShipzip(address.getShipzip());
        billingOrder.setCart_id("1");
        billingOrder.setCreditscorerangetype(address.getCreditscorerangetype());
        billingOrder.setCustomername(address.getCustomername());
        billingOrder.setCardno(address.getCardno());
        billingOrder.setExpirydate(address.getExpirydate());
        billingOrder.setCvv(address.getCvv());
        billingOrder.setStore(address.getStore());

        shippingAndBillingRepository.save(billingOrder);
        PersonalInformationResponse personalInformationResponse = new PersonalInformationResponse();

        ArrayList<OrderDetails> orderDetails = new ArrayList();
        OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setOrderid(String.valueOf(shippingAndBillingRepository.count()));
        orderDetails.add(orderDetails1);
        personalInformationResponse.setOrderdetails(orderDetails);
        return personalInformationResponse;
    }


}
