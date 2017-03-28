package com.product;

import javax.persistence.*;

@Entity
public class ProductDetails {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Product product;
    private String more_description;
    private String warranty;
    private String processor;
    private String vendor;
    private String store_num;

    public ProductDetails(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getMore_description() {
        return more_description;
    }

    public void setMore_description(String more_description) {
        this.more_description = more_description;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getStore_num() {
        return store_num;
    }

    public void setStore_num(String store_num) {
        this.store_num = store_num;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "id=" + id +
                ", product=" + product +
                ", more_description='" + more_description + '\'' +
                ", warranty='" + warranty + '\'' +
                ", processor='" + processor + '\'' +
                ", vendor='" + vendor + '\'' +
                ", store_num='" + store_num + '\'' +
                '}';
    }
}
