package com.youngculture.repository;

import com.youngculture.model.Category;
import com.youngculture.model.Product;
import com.youngculture.utils.CategoryUtil;
import com.youngculture.utils.FileReaderUtil;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> findAllProducts(InputStream inputStream) {
        return FileReaderUtil.readAllProducts(inputStream);
    }

    @Override
    public List<Product> findAllProductsFromASpecificCategory(InputStream inputStream,
                                                              String category) {

        return FileReaderUtil.readAllProducts(inputStream)
                .stream()
                .filter(product -> product.getCategory() ==
                        CategoryUtil.processCategory(category))
                .collect(Collectors.toList());
    }


    @Override
    public Product findProductByName(InputStream inputStream, String productName) {
        return FileReaderUtil.readAllProducts(inputStream)
                .stream().filter(product -> product.getName().equals(productName))
                .findFirst().orElse(null);
    }

}
