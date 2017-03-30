package com.cart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Order {

	@Id
	@GeneratedValue
	private Long id;
	private String cartid;
	private String lastname;
	private String firstname;
	private String email;
	private String phone;
	private String currentcarrier;;
	private String creditscorerangetype;
	private String shiptype;
	private String shipaddress1;
	private String shipaddress2;
	private String shipcity;
	private String shipstate;
	private String shipzip;
	private String billaddress1;
	private String billaddress2;
	private String billcity;
	private String billstate;
	private String billzip;
	private String customername;
	private String cardno;
	private String expirydate;
	private String cvv;
	private String store;
	private String createdAt;
	private String updatedAt;

	public Order() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCartid() {
		return cartid;
	}

	public void setCartid(String cartid) {
		this.cartid = cartid;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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

	public String getCreditscorerangetype() {
		return creditscorerangetype;
	}

	public void setCreditscorerangetype(String creditscorerangetype) {
		this.creditscorerangetype = creditscorerangetype;
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

	public String getBilladdress2() {
		return billaddress2;
	}

	public void setBilladdress2(String billaddress2) {
		this.billaddress2 = billaddress2;
	}

	public String getBillcity() {
		return billcity;
	}

	public void setBillcity(String billcity) {
		this.billcity = billcity;
	}

	public String getBillstate() {
		return billstate;
	}

	public void setBillstate(String billstate) {
		this.billstate = billstate;
	}

	public String getBillzip() {
		return billzip;
	}

	public void setBillzip(String billzip) {
		this.billzip = billzip;
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

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

}
