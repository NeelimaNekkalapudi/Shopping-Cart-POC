package com.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {

    @Id
    private String id;
    private String epid;
    private String name;
    private String description;
    private double retail_price;
    private double sale_price;
    private int promotion;
    private String size;
    private String configuration;
    private String color;
    private String skuid;
    private String picture;
    private int active;
    private String contract;
    private String store;

    public Product(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEpid() {
        return epid;
    }

    public void setEpid(String epid) {
        this.epid = epid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(double retail_price) {
        this.retail_price = retail_price;
    }

    public double getSale_price() {
        return sale_price;
    }

    public void setSale_price(double sale_price) {
        this.sale_price = sale_price;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSkuid() {
        return skuid;
    }

    public void setSkuid(String skuid) {
        this.skuid = skuid;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", epid='" + epid + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", retail_price=" + retail_price +
                ", sale_price=" + sale_price +
                ", promotion=" + promotion +
                ", size='" + size + '\'' +
                ", configuration='" + configuration + '\'' +
                ", color='" + color + '\'' +
                ", skuid='" + skuid + '\'' +
                ", picture='" + picture + '\'' +
                ", active=" + active +
                ", contract='" + contract + '\'' +
                ", store='" + store + '\'' +
                '}';
    }
}
