package com.youngculture.service;

import com.youngculture.model.Product;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts(InputStream inputStream);

    List<Product> getAllProductsFromASpecificCategory(InputStream inputStream,
                                                      String categoryString);

    Product getProductByName(InputStream inputStream, String productName);

    void handleAddToCart(InputStream inputStream, String productName)
            throws IOException;

    List<Product> handleGetProducts(InputStream inputStream, String buttonCategory);

    boolean handleCategoryFieldRendered(String buttonCategory);

    /*Integer countProducts(InputStream inputStream);

    Integer countProductsFromASpecificCategory(InputStream inputStream,
                                               String categoryString);*/

}
