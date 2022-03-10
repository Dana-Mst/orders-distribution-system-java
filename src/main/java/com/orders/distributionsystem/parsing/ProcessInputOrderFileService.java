package com.orders.distributionsystem.parsing;

import com.orders.distributionsystem.order.Order;
import com.orders.distributionsystem.order.OrdersRootElement;
import com.orders.distributionsystem.product.Product;
import com.orders.distributionsystem.product.ProductOutput;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessInputOrderFileService implements InputProcessor{
    private final File inputFile;
    private final String uniqueFileIdentifier;

    private static final int ORDER_START_NUMBER_INDEX = 6;
    private static final String ONLY_DIGITS_REGEX = "[0-9]+";
    private static final String ORDER_SEPARATOR = "\\.";
    private static final String XML_EXTENSION = "xml";

    public ProcessInputOrderFileService(String inputFilePath) throws IOException {
        this.inputFile = new File(inputFilePath);
        if (!inputFile.exists()) {
            throw new IOException("File doesn't exists");
        }

        if (!validateOrderFileName(inputFile.getName())) {
            throw new IOException("Unsupported file naming");
        }
        this.uniqueFileIdentifier = parseUniqueIdentifier(inputFile.getName());
    }

    public Map<String, List<ProductOutput>> getProductsForSuppliers() {
        Map<String, List<ProductOutput>> productsPerSuppliersMap = new HashMap<>();
        List<Product> productsListFromFile = getProductListFromFile();

        for (Product product: productsListFromFile){
            if (!productsPerSuppliersMap.containsKey(product.getSupplier())){
                ArrayList<ProductOutput> productsListForSupplier = new ArrayList<>();
                productsPerSuppliersMap.put(product.getSupplier(), productsListForSupplier);
            }

            ProductOutput productOutput = new ProductOutput();
            productOutput.setDescription(product.getDescription());
            productOutput.setGtin(product.getGtin());
            productOutput.setPrice(product.getPrice());
            productOutput.setOrderId(product.getOrderId());
            productsPerSuppliersMap.get(product.getSupplier()).add(productOutput);
        }

        return productsPerSuppliersMap;
    }

    private List<Product> getProductListFromFile() {
        OrdersRootElement ordersRootElement = getOrdersObjectFromFile();
        List<Product> productsFromFile = new ArrayList<>();
        for(Order order : ordersRootElement.getOrders()) {
            for(Product product : order.getProducts()) {
                product.setOrderId(order.getId());
                productsFromFile.add(product);
            }
        }
        return productsFromFile;
    }

    private OrdersRootElement getOrdersObjectFromFile() {
        OrdersRootElement orders = null;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(OrdersRootElement.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            orders = (OrdersRootElement) unmarshaller.unmarshal(inputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return orders;
    }

    private static Boolean validateOrderFileName(String fileName) {
        var splittedFile = fileName.split(ORDER_SEPARATOR);
        var fileExtension = splittedFile[1];
        var fileWithoutExtension = splittedFile[0];
        var fileHasCorrectStructure = fileWithoutExtension.substring(ORDER_START_NUMBER_INDEX)
                .matches(ONLY_DIGITS_REGEX);

        return fileExtension.equals(XML_EXTENSION) && fileHasCorrectStructure;
    }

    private static String parseUniqueIdentifier(String fileName){
        var splittedFile = fileName.split(ORDER_SEPARATOR);
        var fileWithoutExtension = splittedFile[0];

        return fileWithoutExtension.substring(ORDER_START_NUMBER_INDEX);
    }

    public String getInputUniqueIdentifier(){
        return uniqueFileIdentifier;
    }

}
