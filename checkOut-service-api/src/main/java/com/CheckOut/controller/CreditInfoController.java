package com.CheckOut.controller;

import com.CheckOut.model.CreditInfo;
import com.CheckOut.model.Customer;
import com.CheckOut.model.Order;
import com.CheckOut.repository.PersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/checkout", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:8080")
public class CreditInfoController {

    @Autowired
    protected PersonalInfoRepository shippingAndBillingRepository;



    @RequestMapping(value ="/creditinfo" , method = RequestMethod.PATCH)
    public void updateCreditInfo(@RequestBody CreditInfo creditInfo) {

        Order orderInfo = shippingAndBillingRepository.getOrderById(String.valueOf(shippingAndBillingRepository.count()));
        orderInfo.setIdtype(creditInfo.getCustomer().getIdtype());
        orderInfo.setIdnumber(creditInfo.getCustomer().getIdnumber());
        orderInfo.setExpirymonth(creditInfo.getCustomer().getExpirymonth());
        orderInfo.setExpiryyear(creditInfo.getCustomer().getExpiryyear());
        orderInfo.setState(creditInfo.getCustomer().getState());
        orderInfo.setSsn(creditInfo.getCustomer().getSsn());
        orderInfo.setDob(creditInfo.getCustomer().getDob());

        shippingAndBillingRepository.save(orderInfo);



    }
}
