package com.orders.distributionsystem.parsing;

import com.orders.distributionsystem.product.ProductOutput;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface InputProcessor {

    void setFile(String inputFilePath) throws IOException;
    Map<String, List<ProductOutput>> getProductsForSuppliers();
    String getInputUniqueIdentifier();
}
