package com.youngculture.servlet;

import com.youngculture.model.Product;
import com.youngculture.service.ProductService;
import com.youngculture.service.ProductServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    private final static long serialVersionUID = 1L;

    private static List<Product> productList;
    private static boolean categoryRendered = true;
    private final static String resourceFile = "/WEB-INF/resources/products.txt";

    ProductService productService = new ProductServiceImpl();

    public ProductServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        InputStream inputStream =
                context.getResourceAsStream(resourceFile);

        String buttonCategory = request.getParameter("categoryButton");
        productList = productService.handleGetProducts(inputStream, buttonCategory);
        categoryRendered = productService.handleCategoryFieldRendered(buttonCategory);

        setRequestAttributes(request);
        request.getRequestDispatcher("product.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        InputStream inputStream =
                context.getResourceAsStream(resourceFile);

        String productName = request.getParameter("productNameFromButton");
        productService.handleAddToCart(inputStream, productName);

        setRequestAttributes(request);
        request.getRequestDispatcher("product.jsp")
                .forward(request, response);
    }

    private void setRequestAttributes(HttpServletRequest request) {
        request.setAttribute("rendered", categoryRendered);
        request.setAttribute("products", productList);
    }

}
