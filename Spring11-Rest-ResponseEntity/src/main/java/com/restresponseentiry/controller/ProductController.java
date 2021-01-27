package com.restresponseentiry.controller;

import com.restresponseentiry.entity.Product;
import com.restresponseentiry.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {

        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {

        HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version", "Kate.v1");
        responseHttpHeaders.set("Operation", "Get List");

        return ResponseEntity
                .ok()
                .headers(responseHttpHeaders)
                .body(productService.getProducts());
    }

    @PostMapping
    public ResponseEntity<List<Product>> createProduct(@RequestBody Product product) {

        List<Product> set = productService.createProduct(product);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Version", "Kate.v2")
                .header("Operation", "Create")
                .body(set);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<List<Product>> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("Version", "Kate.v3");
        map.add("Operation", "Update");

        List<Product> list = productService.updateProduct(id, product);

        return new ResponseEntity <>(list, map, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<List<Product>> delete(@PathVariable("id") long id) {

        HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version", "Kate.v4");
        responseHttpHeaders.set("Operation", "Delete");

        List<Product> list = productService.delete(id);

        return new ResponseEntity<>(list,responseHttpHeaders,HttpStatus.OK);
    }

}
