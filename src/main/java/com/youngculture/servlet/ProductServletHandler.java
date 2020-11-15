package com.youngculture.servlet;

import com.youngculture.model.Product;
import com.youngculture.service.ProductService;
import com.youngculture.service.ProductServiceImpl;
import com.youngculture.utils.FileWriterUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ProductServletHandler {

    private static final ProductService productService = new ProductServiceImpl();

    public static void handleAddToCart(InputStream inputStream,
                                       String productName) throws IOException {
        FileWriterUtil.writeProductToFile(
                productService.getProductByName(inputStream, productName));
    }

    public static List<Product> handleGetProducts(InputStream inputStream,
                                                  String category) {
        List<Product> products;
        if (category == null || category.equals("all")) {
            products = productService.getAllProducts(inputStream);
        } else {
            products = productService.getAllProductsFromASpecificCategory(
                    inputStream, category);
        }
        return products;
    }

    public static boolean handleCategoryFieldRendered(String category) {
        return category == null || category.equals("all");
    }

}
