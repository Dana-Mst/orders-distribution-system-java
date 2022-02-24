package com.orders.distributionsystem.order;

import com.orders.distributionsystem.product.Product;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;


public class Order {

    private String id;
    private String createdAt;
    private List<Product> products;

    public Order() {
    }

    public Order(String id, String createdAt, List<Product> products) {
        this.id = id;
        this.createdAt = createdAt;
        this.products = products;
    }

    @XmlAttribute(name="ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlAttribute(name="created")
    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @XmlElement(name="product")
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
