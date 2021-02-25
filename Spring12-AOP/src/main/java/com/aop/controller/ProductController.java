package com.aop.controller;


import com.aop.entity.Product;
import com.aop.entity.ResponseWrapper;
import com.aop.service.ProductService;
import lombok.ToString;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ToString
@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {

        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping
    public List<Product> getProducts() {
        List<Product> list = productService.getProducts();
        return list;
    }

    @PostMapping
    public List<Product> createProduct(@RequestBody Product product) {

        List<Product> set = productService.createProduct(product);
//        return
        return set;
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<List<Product>> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("Version", "Kate.v3");
        map.add("Operation", "Update");

        List<Product> list = productService.updateProduct(id, product);

        return new ResponseEntity<>(list, map, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<List<Product>> delete(@PathVariable("id") long id) {

        HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version", "Kate.v4");
        responseHttpHeaders.set("Operation", "Delete");

        List<Product> list = productService.delete(id);

        return new ResponseEntity<>(list, responseHttpHeaders, HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<ResponseWrapper> readAllProducts() {
        return ResponseEntity
                .ok(new ResponseWrapper("products successfully retrieved", productService.getProducts()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseWrapper> deleteProduct(@PathVariable("id") long id) {
        return ResponseEntity
                .ok(new ResponseWrapper("product successfully deleted"));
    }

    @DeleteMapping("/delete2/{id}")
    public ResponseEntity<ResponseWrapper> deleteProduct2(@PathVariable("id") long id) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new ResponseWrapper("product successfully deleted"));
    }

}
