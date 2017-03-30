package com.CheckOut.model;

/**
 * Created by kvajramani on 28-03-2017.
 */
public class PersonalInformation {

    public String orderId;

    public String firstName;

    public String lastName;

    public String email;

    public String phone;

    public String currentCarrier;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCurrentCarrier() {
        return currentCarrier;
    }

    public void setCurrentCarrier(String currentCarrier) {
        this.currentCarrier = currentCarrier;
    }
}
