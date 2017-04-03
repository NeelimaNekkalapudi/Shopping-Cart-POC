package com.CheckOut.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Created by kvajramani on 28-03-2017.
 */
@Document
public class Order {

    @Id
    public String id;

    public String firstname;

    public String lastname;

    public String email;

    public String phone;

    public String getCart_id() {
        return Cart_id;
    }

    public void setCart_id(String cart_id) {
        Cart_id = cart_id;
    }

    public String Cart_id;



    public String currentcarrier;

    public String shiptype;

    public String shipaddress1;

    public String shipaddress2;

    public String shipcity;

    public String shipstate;

    public String shipzip;

    public String billaddress1;

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

    public String getShiptype() {
        return shiptype;
    }

    public void setShiptype(String shiptype) {
        this.shiptype = shiptype;
    }

    public String getShipaddress1() {
        return shipaddress1;
    }

    public void setShipaddress1(String shipaddress1) {
        this.shipaddress1 = shipaddress1;
    }

    public String getShipaddress2() {
        return shipaddress2;
    }

    public void setShipaddress2(String shipaddress2) {
        this.shipaddress2 = shipaddress2;
    }

    public String getShipcity() {
        return shipcity;
    }

    public void setShipcity(String shipcity) {
        this.shipcity = shipcity;
    }

    public String getShipstate() {
        return shipstate;
    }

    public void setShipstate(String shipstate) {
        this.shipstate = shipstate;
    }

    public String getShipzip() {
        return shipzip;
    }

    public void setShipzip(String shipzip) {
        this.shipzip = shipzip;
    }

    public String getBilladdress1() {
        return billaddress1;
    }

    public void setBilladdress1(String billaddress1) {
        this.billaddress1 = billaddress1;
    }

    public String getBillstate() {
        return billstate;
    }

    public void setBillstate(String billstate) {
        this.billstate = billstate;
    }

    public String getBillcity() {
        return billcity;
    }

    public void setBillcity(String billcity) {
        this.billcity = billcity;
    }

    public String getBilladdress2() {
        return billaddress2;
    }

    public void setBilladdress2(String billaddress2) {
        this.billaddress2 = billaddress2;
    }

    public String getBillzip() {
        return billzip;
    }

    public void setBillzip(String billzip) {
        this.billzip = billzip;
    }

    public String getCreditscorerangetype() {
        return creditscorerangetype;
    }

    public void setCreditscorerangetype(String creditscorerangetype) {
        this.creditscorerangetype = creditscorerangetype;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String billaddress2;

    public String billcity;

    public String billstate;

    public String billzip;

    public String creditscorerangetype;

    public String customername;

    public String cardno;

    public String expirydate;

    public String cvv;

    public String store;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
