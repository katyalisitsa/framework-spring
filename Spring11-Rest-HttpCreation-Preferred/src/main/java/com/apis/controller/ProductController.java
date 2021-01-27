package com.apis.controller;


import com.apis.entity.Product;
import com.apis.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "{id}")
    public Product getProduct(@PathVariable("id") long id) {
        return productService.getProduct(id);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public List<Product> createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping(value = "{id}")
    public List<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping(value = "{id}")
    public List<Product> delete(@PathVariable("id") long id) {
        return productService.delete(id);
    }

}
