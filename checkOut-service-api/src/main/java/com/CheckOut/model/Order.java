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

    public String firstName;

    public String lastName;

    public String email;

    public String phone;

    public String currentCarrier;

    public String shipType;

    public String shipAddress1;

    public String shipAddress2;

    public String shipCity;

    public String shipState;

    public String shipZip;

    public String billAddress1;

    public String billAddress2;

    public String billCity;

    public String billState;

    public String billZip;

    public String cartId;

    public String creditsCoreRangeType;

    public String customerName;

    public String cardNo;

    public String expiryDate;

    public String cvv;

    public String store;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
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

    public String getShipAddress1() {
        return shipAddress1;
    }

    public void setShipAddress1(String shipAddress1) {
        this.shipAddress1 = shipAddress1;
    }

    public String getShipAddress2() {
        return shipAddress2;
    }

    public void setShipAddress2(String shipAddress2) {
        this.shipAddress2 = shipAddress2;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipZip() {
        return shipZip;
    }

    public void setShipZip(String shipZip) {
        this.shipZip = shipZip;
    }

    public String getShipState() {
        return shipState;
    }

    public void setShipState(String shipState) {
        this.shipState = shipState;
    }

    public String getBillAddress1() {
        return billAddress1;
    }

    public void setBillAddress1(String billAddress1) {
        this.billAddress1 = billAddress1;
    }

    public String getBillAddress2() {
        return billAddress2;
    }

    public void setBillAddress2(String billAddress2) {
        this.billAddress2 = billAddress2;
    }

    public String getBillCity() {
        return billCity;
    }

    public void setBillCity(String billCity) {
        this.billCity = billCity;
    }

    public String getBillState() {
        return billState;
    }

    public void setBillState(String billState) {
        this.billState = billState;
    }

    public String getBillZip() {
        return billZip;
    }

    public void setBillZip(String billZip) {
        this.billZip = billZip;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getCreditsCoreRangeType() {
        return creditsCoreRangeType;
    }

    public void setCreditsCoreRangeType(String creditsCoreRangeType) {
        this.creditsCoreRangeType = creditsCoreRangeType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
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
}
