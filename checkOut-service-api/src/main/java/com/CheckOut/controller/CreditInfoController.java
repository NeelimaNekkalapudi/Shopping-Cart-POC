package com.CheckOut.controller;

import com.CheckOut.model.CustomerInformation;
import com.CheckOut.model.Order;
import com.CheckOut.repository.PersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/checkout", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:8080")
public class CreditInfoController {

    @Autowired
    protected PersonalInfoRepository shippingAndBillingRepository;

   @RequestMapping(value ="/creditinfo" , method = RequestMethod.PATCH)
    public void updateCreditInfo(@RequestBody CustomerInformation customer) {

        Order orderInfo = shippingAndBillingRepository.getOrderById(String.valueOf(shippingAndBillingRepository.count()));
        orderInfo.setIdtype(customer.getIdtype());
        orderInfo.setIdnumber(customer.getIdnumber());
        orderInfo.setExpirymonth(customer.getExpirymonth());
        orderInfo.setExpiryyear(customer.getExpiryyear());
        orderInfo.setState(customer.getState());
        orderInfo.setSsn(customer.getSsn());
        orderInfo.setDob(customer.getDob());


        shippingAndBillingRepository.save(orderInfo);


    }
}
