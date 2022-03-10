package com.orders.distributionsystem.parsing;

import com.orders.distributionsystem.product.ProductOutput;
import com.orders.distributionsystem.product.ProductsOutputRootElement;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class OutputProductsForSuppliersService implements OutputProcessor {
    private final String uniqueIdentifier;

    public OutputProductsForSuppliersService(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    public void exportProductsForSuppliers(Map<String, List<ProductOutput>> suppliersProducts) {
        for (String supplier : suppliersProducts.keySet()) {
            ProductsOutputRootElement supplierRoot = new ProductsOutputRootElement();
            supplierRoot.setProducts(suppliersProducts.get(supplier));
            try {
                objectToXML(supplierRoot, supplier);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void objectToXML(ProductsOutputRootElement productsRootElement, String supplier) throws IOException, JAXBException {

        String outputFileSupplier = supplier.toLowerCase() + uniqueIdentifier + ".xml";
        File outputSupplierFile = new File("exported/" + supplier, outputFileSupplier);
        if (outputSupplierFile.exists()){
            throw new IOException ("Supplier location file already exists");
        }
        outputSupplierFile.getParentFile().mkdirs();

        JAXBContext jaxbContext = JAXBContext.newInstance(ProductsOutputRootElement.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(productsRootElement, outputSupplierFile);
    }

}
