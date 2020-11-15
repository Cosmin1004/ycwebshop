package com.youngculture.utils;

import com.youngculture.model.Category;
import com.youngculture.model.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {

    public static List<Product> readAllProducts(InputStream inputStream) {
        List<Product> productList = new ArrayList<>();
        try (BufferedReader fileReader =
                     new BufferedReader(new InputStreamReader(inputStream))) {
            String line = fileReader.readLine();
            boolean skipLine = false;

            while (line != null) {
                if (line.isEmpty()
                        || line.startsWith("##")) {
                    skipLine = true;
                }

                if ( ! skipLine) {
                    String[] values = line.split(";");
                    Product product = createProduct(values);
                    productList.add(product);
                }

                skipLine = false;

                line = fileReader.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return productList;
    }

    private static Product createProduct(String[] values) {
        String name = values[0].trim();
        Category category = CategoryUtil.processCategory(values[1].trim());
        String description = values[2].trim();
        Double price = Double.parseDouble(values[3].trim());

        return new Product.Builder()
                .setName(name)
                .setCategory(category)
                .setDescription(description)
                .setPrice(price)
                .build();
    }

}


