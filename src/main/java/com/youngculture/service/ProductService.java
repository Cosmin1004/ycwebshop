package com.youngculture.service;

import com.youngculture.model.Product;

import java.io.InputStream;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts(InputStream inputStream);

    List<Product> getAllProductsFromASpecificCategory(InputStream inputStream,
                                                      String category);

    Product getProductByName(InputStream inputStream, String productName);

}
