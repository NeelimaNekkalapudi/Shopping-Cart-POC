package com.dashboard.model;

import java.util.ArrayList;

    public class PersonalInformation {

    public String orderId;

    public String firstname;

    public String lastname;

    public String email;

    public String phone;

    public String currentcarrier;

    public String username;

    public ArrayList productsList;

    public ArrayList accessoriesList;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getCurrentcarrier() {
        return currentcarrier;
    }

    public void setCurrentcarrier(String currentcarrier) {
        this.currentcarrier = currentcarrier;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList getProductsList() {
        return productsList;
    }

    public void setProductsList(ArrayList productsList) {
        this.productsList = productsList;
    }

    public ArrayList getAccessoriesList() {
        return accessoriesList;
    }

    public void setAccessoriesList(ArrayList accessoriesList) {
        this.accessoriesList = accessoriesList;
    }
}
