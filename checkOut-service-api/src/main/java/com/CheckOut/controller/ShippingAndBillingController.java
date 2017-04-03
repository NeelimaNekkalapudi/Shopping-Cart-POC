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
            billingOrder.setBillAddress1(address.getBillingAddress1());
            billingOrder.setBillAddress2(address.getBillingAddress2());
            billingOrder.setBillCity(address.getBillingCity());
            billingOrder.setBillState(address.getBillingState());
            billingOrder.setBillZip(address.getBillingZip());
            billingOrder.setShipAddress1(address.getShippingAddress1());
            billingOrder.setShipAddress2(address.getShippingAddress2());
            billingOrder.setShipCity(address.getShippingCity());
            billingOrder.setShipState(address.getShippingState());
            billingOrder.setShipZip(address.getShippingZip());
            billingOrder.setCartId("1");
            billingOrder.setCreditsCoreRangeType(address.getCreditsCoreRangeType());
            billingOrder.setCustomerName(address.getCustomerName());
            billingOrder.setCardNo(address.getCardNo());
            billingOrder.setExpiryDate(address.getExpiryDate());
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
