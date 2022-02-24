package com.orders.distributionsystem.product;

import javax.xml.bind.annotation.XmlTransient;

public class ProductOutput extends Product{

    @Override
    @XmlTransient
    public String getSupplier() {
        return super.getSupplier();
    }
}
