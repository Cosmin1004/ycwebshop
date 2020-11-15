package com.youngculture.service;

import com.youngculture.model.Product;
import com.youngculture.repository.ProductRepository;
import com.youngculture.repository.ProductRepositoryImpl;
import com.youngculture.utils.FileWriterUtil;

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
                                                             String categoryString) {
        return productRepository
                .findAllProductsFromASpecificCategory(inputStream, categoryString);
    }

    @Override
    public Product getProductByName(InputStream inputStream,
                                    String productName) {
        return productRepository.findProductByName(inputStream, productName);
    }

    @Override
    public void handleAddToCart(InputStream inputStream, String productName) {
        Product product = getProductByName(inputStream, productName);
        FileWriterUtil.writeProductToFile(product);
    }

    @Override
    public List<Product> handleGetProducts(InputStream inputStream,
                                           String category) {
        List<Product> products;
        if (category == null || category.equals("all")) {
            products = getAllProducts(inputStream);
        } else {
            products = getAllProductsFromASpecificCategory(inputStream,
                    category);
        }

        return products;
    }

    @Override
    public boolean handleCategoryFieldRendered(String category) {
        boolean rendered = false;
        if (category == null || category.equals("all")) {
            rendered = true;
        }

        return rendered;
    }

}
