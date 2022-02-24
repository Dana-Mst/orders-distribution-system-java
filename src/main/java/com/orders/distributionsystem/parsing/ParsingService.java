package com.orders.distributionsystem.parsing;

import java.io.IOException;

public class ParsingService {


    public boolean processOrderFile(String fileAbsolutePath){
            ProcessInputOrderFileService inputProcessor = new ProcessInputOrderFileService();

            try {
                inputProcessor.setFile(fileAbsolutePath);
            }catch (IOException e){
                return false;
            }

            var suppliersProducts = inputProcessor.getProductsForSuppliers();

            OutputProcessor outputProcessor = new OutputProductsForSuppliersService(inputProcessor.getInputUniqueIdentifier());
            outputProcessor.exportProductsForSuppliers(suppliersProducts);

            return true;
        }
}
