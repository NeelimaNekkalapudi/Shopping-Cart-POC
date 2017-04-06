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

   /*@RequestMapping(value ="/creditinfo" , method = RequestMethod.PATCH)
    public void updateCreditInfo(@RequestBody Customer customer) {

        Order orderInfo = shippingAndBillingRepository.getOrderById(String.valueOf(shippingAndBillingRepository.count()));
        orderInfo.setIdtype(customer.getIdtype());
        orderInfo.setIdnumber(customer.getIdnumber());
        orderInfo.setExpirymonth(customer.getExpirymonth());
        orderInfo.setExpiryyear(customer.getExpiryyear());
        orderInfo.setState(customer.getState());
        orderInfo.setSsn(customer.getSsn());
        orderInfo.setDob(customer.getDob());


        shippingAndBillingRepository.save(orderInfo);


    }*/


    @RequestMapping(value ="/creditinfo" , method = RequestMethod.PATCH)
    public void updateCreditInfo(@RequestBody CreditInfo creditInfo) {

        //Customer customer = new Customer();

        ArrayList<Customer> customerInformationCollection = new ArrayList<Customer>();


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
