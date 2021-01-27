package com.apis.bootstrap;


import com.apis.entity.Product;
import com.apis.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;

public class DataGenerator implements CommandLineRunner {

    private ProductRepository productRepository;

    public DataGenerator(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Product pc = new Product("Dell");
        Product laptop = new Product("MacBook");
        Product phone = new Product("IPhone");
        Product tablet = new Product("IPad");

        productRepository.save(pc);
        productRepository.save(laptop);
        productRepository.save(phone);
        productRepository.save(tablet);


    }
}
