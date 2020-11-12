package com.youngculture.repository;

import com.youngculture.model.Product;

import java.io.InputStream;
import java.util.List;

public interface ProductRepository {

    List<Product> getAllProducts(InputStream inputStream);

    List<Product> getAllProductsFromASpecificCategory(InputStream inputStream, String categoryString);

    Integer countProducts(InputStream inputStream);

    Integer countProductsFromASpecificCategory(InputStream inputStream, String categoryString);

}
