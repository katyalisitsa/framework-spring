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

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") long id) {
        return productService.getProduct(id);
    }

    @RequestMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Product> createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public List<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public List<Product> delete(@PathVariable("id") long id) {
        return productService.delete(id);
    }

}
