package com.orders.distributionsystem.order;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="orders")
public class OrdersRootElement {
    private List<Order> orders;

    public OrdersRootElement() {
    }

    public OrdersRootElement(List<Order> orders) {
        this.orders = orders;
    }

    @XmlElement(name="order")
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
