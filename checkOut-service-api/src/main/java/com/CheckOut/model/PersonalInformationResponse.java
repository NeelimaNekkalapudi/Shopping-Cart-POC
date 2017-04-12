package com.CheckOut.model;

import java.util.ArrayList;

/**
 * Created by kvajramani on 31-03-2017.
 */
public class PersonalInformationResponse {

    public ArrayList<OrderDetails> orderdetails;

    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<OrderDetails> getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(ArrayList<OrderDetails> orderdetails) {
        this.orderdetails = orderdetails;
    }
}
