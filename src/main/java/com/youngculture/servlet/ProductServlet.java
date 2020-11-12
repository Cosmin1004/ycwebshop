package com.youngculture.servlet;

import com.youngculture.repository.ProductRepository;
import com.youngculture.repository.ProductRepositoryImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final static String resourceFile = "/WEB-INF/resources/products.txt";
    ProductRepository productRepository = new ProductRepositoryImpl();

    public ProductServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        InputStream inputStream =
                context.getResourceAsStream(resourceFile);
        request.setAttribute("products",
                productRepository.getAllProducts(inputStream));
        request.getRequestDispatcher("product.jsp")
                .forward(request, response);
    }
}
