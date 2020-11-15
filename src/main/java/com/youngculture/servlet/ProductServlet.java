package com.youngculture.servlet;

import com.youngculture.model.Product;

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
    private final static String resourceFile = "/WEB-INF/resources/products.txt";
    private static List<Product> productList;
    private static boolean categoryRendered = true;

    public ProductServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        InputStream inputStream = setInputStream();

        String category = request.getParameter("category");
        productList = ProductServletHandler.handleGetProducts(inputStream, category);
        categoryRendered = ProductServletHandler.handleCategoryFieldRendered(category);

        setRequestAttributes(request);
        request.getRequestDispatcher("product.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        InputStream inputStream = setInputStream();

        String productName = request.getParameter("productNameFromButton");
        ProductServletHandler.handleAddToCart(inputStream, productName);

        setRequestAttributes(request);
        request.getRequestDispatcher("product.jsp")
                .forward(request, response);
    }

    private InputStream setInputStream() {
        ServletContext context = getServletContext();
        return context.getResourceAsStream(resourceFile);
    }

    private void setRequestAttributes(HttpServletRequest request) {
        request.setAttribute("rendered", categoryRendered);
        request.setAttribute("products", productList);
    }

}
