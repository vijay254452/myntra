package com.myntra.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // Root URL (http://localhost:8080/)
    @GetMapping("/")
    public String home() {
        return "Welcome to Myntra - Fashion Delivered!";
    }

    // Example product page (http://localhost:8080/products)
    @GetMapping("/products")
    public String products() {
        return "Browse our latest Myntra fashion collection.";
    }

    // Example offers page (http://localhost:8080/offers)
    @GetMapping("/offers")
    public String offers() {
        return "Check out the hottest Myntra offers today!";
    }
}

