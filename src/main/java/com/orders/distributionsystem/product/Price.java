package com.orders.distributionsystem.product;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class Price {

    private String currency;
    private String value;

    public Price() {
    }

    public Price(String currency, String price) {
        this.currency = currency;
        this.value = price;
    }

    @XmlAttribute(name="currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @XmlValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
