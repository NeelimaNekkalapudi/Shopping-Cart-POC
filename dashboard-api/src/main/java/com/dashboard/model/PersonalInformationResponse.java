package com.dashboard.model;

import java.util.ArrayList;

public class PersonalInformationResponse {

    public ArrayList<OrderDetails> orderDetails;

    public ArrayList<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
