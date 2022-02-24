package com.orders.distributionsystem.product;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="products")
public class ProductsOutputRootElement {

    private List<ProductOutput> products;

    public ProductsOutputRootElement() {
    }

    public ProductsOutputRootElement(List<ProductOutput> products) {
        this.products = products;
    }

    @XmlElement(name="product")
    public List<ProductOutput> getProducts() {
        return products;
    }

    public void setProducts(List<ProductOutput> products) {
        this.products = products;
    }
}
