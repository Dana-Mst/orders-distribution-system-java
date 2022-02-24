package com.orders.distributionsystem.parsing;

import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class ParsingService {


    public boolean processOrderFile(String fileAbsolutePath){
            ProcessInputOrderFileService inputProcessor = new ProcessInputOrderFileService();

            try {
                inputProcessor.setFile(fileAbsolutePath);
            }catch (IOException e){
                return false;
            }

            var suppliersProducts = inputProcessor.getProductsForSuppliers();

            OutputProductsForSuppliersService outputProcessor = new OutputProductsForSuppliersService(inputProcessor.getInputUniqueIdentifier());
            outputProcessor.exportProductsForSuppliers(suppliersProducts);

            return true;
        }
}
