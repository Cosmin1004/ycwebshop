package com.youngculture.service;

import com.youngculture.model.Product;
import com.youngculture.repository.ProductRepository;
import com.youngculture.repository.ProductRepositoryImpl;

import java.io.InputStream;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> getAllProducts(InputStream inputStream) {
        return productRepository.findAllProducts(inputStream);
    }

    @Override
    public List<Product> getAllProductsFromASpecificCategory(InputStream inputStream,
                                                             String category) {
        return productRepository
                .findAllProductsFromASpecificCategory(inputStream, category);
    }

    @Override
    public Product getProductByName(InputStream inputStream,
                                    String productName) {
        return productRepository.findProductByName(inputStream, productName);
    }

}
