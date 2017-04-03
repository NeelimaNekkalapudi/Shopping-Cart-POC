package com.CheckOut.controller;

/**
 * Created by kvajramani on 28-03-2017.
 */

import com.CheckOut.model.AddressDetails;
import com.CheckOut.model.Order;
import com.CheckOut.repository.PersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/checkout", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:8080")
public class ShippingAndBillingController {


    @Autowired
    protected PersonalInfoRepository shippingAndBillingRepository;

    @RequestMapping(value ="/billandship" , method = RequestMethod.PATCH)
    public void updateOrder(@RequestBody AddressDetails address) {
       /* if(address.getOrderId()!= null) {*/
            Order billingOrder = shippingAndBillingRepository.getOrderById(address.getOrderId());
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
      /*  }*/

           /* Order billingOrder = shippingAndBillingRepository.getOrderById("3");
            billingOrder.setShipType("myShip");
            billingOrder.setBillAddress1("billaddress1");
            billingOrder.setBillAddress2("billaddress2");
            billingOrder.setBillCity("billCity");
            billingOrder.setBillState("billstate");
            billingOrder.setBillZip("billZip");
            billingOrder.setShipAddress1("shipAddress1");
            billingOrder.setShipAddress2("shipAddress2");
            billingOrder.setShipCity("shipCity");
            billingOrder.setShipState("shipState");
            billingOrder.setShipZip("shipZip");
            billingOrder.setCartId("1");
            billingOrder.setCreditsCoreRangeType("rangeOne");
            billingOrder.setCustomerName("Customer1");
            billingOrder.setCardNo("1234567890123456");
            billingOrder.setExpiryDate("30032017");
            billingOrder.setCvv("105");
            billingOrder.setStore("tMobileStore");*/


        shippingAndBillingRepository.save(billingOrder);
    }

}
