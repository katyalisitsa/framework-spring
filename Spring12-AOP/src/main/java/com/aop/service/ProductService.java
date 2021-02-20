package com.aop.service;

import com.restresponseentiry.entity.Product;

import java.util.List;


public interface ProductService {

    List<Product> getProducts();

    List<Product> delete(long id);

    List<Product> updateProduct(long id, Product product);

    List<Product> createProduct(Product product);

    Product getProduct(long id);

}

