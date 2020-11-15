package com.youngculture.repository;

import com.youngculture.model.Product;

import java.io.InputStream;
import java.util.List;

public interface ProductRepository {

    List<Product> findAllProducts(InputStream inputStream);

    List<Product> findAllProductsFromASpecificCategory(InputStream inputStream,
                                                       String category);

    Product findProductByName(InputStream inputStream, String productName);

}
