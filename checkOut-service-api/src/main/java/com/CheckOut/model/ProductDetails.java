package com.CheckOut.model;

public class ProductDetails {

    private Long id;
    private Long product_id;
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

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "id=" + id +
                ", more_description='" + more_description + '\'' +
                ", warranty='" + warranty + '\'' +
                ", processor='" + processor + '\'' +
                ", vendor='" + vendor + '\'' +
                ", store_num='" + store_num + '\'' +
                '}';
    }
}
