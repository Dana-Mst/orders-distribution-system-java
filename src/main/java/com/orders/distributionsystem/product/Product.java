package com.orders.distributionsystem.product;

import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;

@ToString
public class Product {

    private String description;
    private String gtin;
    private Price price;
    private String supplier;
    private String orderId;

    public Product() {
    }

    public Product(String description, String gtin, Price price, String supplierName) {
        this.description = description;
        this.gtin = gtin;
        this.price = price;
        this.supplier = supplierName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    @XmlElement(name="price")
    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
