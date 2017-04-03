package com.CheckOut.model;

import java.util.ArrayList;

/**
 * Created by kvajramani on 31-03-2017.
 */
public class PersonalInformationResponse {

    public ArrayList<OrderDetails> orderDetails;

    public ArrayList<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
