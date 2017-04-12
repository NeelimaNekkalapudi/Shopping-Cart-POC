package com.CheckOut.controller;

import com.CheckOut.model.PersonalDetails;
import com.CheckOut.model.Order;
import com.CheckOut.model.OrderDetails;
import com.CheckOut.model.PersonalInformationResponse;
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


    /*@HystrixCommand(fallbackMethod = "updatedCreditFallback")*/
    @RequestMapping(value ="/creditinfo" , method = RequestMethod.PATCH)
    public PersonalInformationResponse updateCreditInfo(@RequestBody PersonalDetails creditInfo) {

        Order orderInfo = shippingAndBillingRepository.getOrderById(String.valueOf(shippingAndBillingRepository.count()));
        orderInfo.setIdtype(creditInfo.getCustomer().getIdtype());
        orderInfo.setIdnumber(creditInfo.getCustomer().getIdnumber());
        orderInfo.setExpirymonth(creditInfo.getCustomer().getExpirymonth());
        orderInfo.setExpiryyear(creditInfo.getCustomer().getExpiryyear());
        orderInfo.setState(creditInfo.getCustomer().getState());
        orderInfo.setSsn(creditInfo.getCustomer().getSsn());
        orderInfo.setDob(creditInfo.getCustomer().getDob());
        orderInfo.setStatus("Completed");

        shippingAndBillingRepository.save(orderInfo);

        PersonalInformationResponse personalInformationResponse = new PersonalInformationResponse();

        ArrayList<OrderDetails> orderDetails = new ArrayList();
        OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setOrderid(String.valueOf(shippingAndBillingRepository.count()));
        orderDetails.add(orderDetails1);
        personalInformationResponse.setOrderdetails(orderDetails);
        personalInformationResponse.setMessage("Successfully saved the order");
        return personalInformationResponse;

    }

   /* public void updatedCreditFallback(){
        System.out.println("Please try again after some time");
    }
*/
}
