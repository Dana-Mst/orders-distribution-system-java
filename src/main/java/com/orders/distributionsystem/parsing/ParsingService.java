package com.orders.distributionsystem.parsing;

import java.io.IOException;

public class ParsingService {


    public boolean processOrderFile(String fileAbsolutePath) throws IOException {

            InputProcessor inputProcessor = new ProcessInputOrderFileService(fileAbsolutePath);

            var suppliersProducts = inputProcessor.getProductsForSuppliers();

            OutputProcessor outputProcessor = new OutputProductsForSuppliersService(inputProcessor.getInputUniqueIdentifier());
            outputProcessor.exportProductsForSuppliers(suppliersProducts);

            return true;
        }
}
