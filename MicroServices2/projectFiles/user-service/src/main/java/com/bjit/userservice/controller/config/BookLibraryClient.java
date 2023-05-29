package com.bjit.userservice.controller.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-library") // Specify the name of the Book Library service
public interface BookLibraryClient {

    @GetMapping("/books/showAll") // Specify the endpoint to retrieve all books
    ResponseEntity<Object> getAllBooks();

    @GetMapping("/books/price")
    ResponseEntity<Long> getBookPrice();

    @GetMapping("/books/quantity")
    ResponseEntity<Long> getItemQuantity();
}