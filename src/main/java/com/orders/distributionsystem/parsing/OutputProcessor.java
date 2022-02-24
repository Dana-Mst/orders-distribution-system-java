package com.orders.distributionsystem.parsing;


import com.orders.distributionsystem.product.ProductOutput;

import java.util.List;
import java.util.Map;

public interface OutputProcessor {

    void exportProductsForSuppliers(Map<String, List<ProductOutput>> suppliersProducts);
}
