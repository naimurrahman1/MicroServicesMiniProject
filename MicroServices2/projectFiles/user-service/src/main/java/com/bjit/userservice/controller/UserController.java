package com.bjit.userservice.controller;

import com.bjit.userservice.controller.config.BookLibraryClient;
import com.bjit.userservice.controller.config.OrderServiceClient;
import com.bjit.userservice.entity.UserEntity;
import com.bjit.userservice.model.OrderRequestModel;
import com.bjit.userservice.model.UserRequestModel;
import com.bjit.userservice.model.UserResponseModel;
import com.bjit.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;

    @Autowired
    private final BookLibraryClient bookLibraryClient;

    @Autowired
    private final OrderServiceClient orderServiceClient;


    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody UserRequestModel userRequestModel) {
        return userService.create(userRequestModel);
    }

    @GetMapping("/showAll")
    public ResponseEntity<Object> getAllUsers() {
        return userService.showAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUserById(@PathVariable Long userId) {
        return userService.findByUserId(userId);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Object> updateUser(@PathVariable Long userId, @RequestBody UserRequestModel userRequestModel) {
        return userService.updateUserEntity(userId, userRequestModel);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long userId) {
        return userService.delete(userId);

    }

    @GetMapping("/books")
    public ResponseEntity<Object> getAllBooks() {
        // Use the BookLibraryClient to retrieve all books from the Book Library service
        ResponseEntity<Object> response = bookLibraryClient.getAllBooks();
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    @PostMapping("/createOrder")
    public ResponseEntity<Object> createOrder(@RequestBody OrderRequestModel orderRequestModel) {
        // Use the OrderServiceClient to create an order via the order-service
        ResponseEntity<Object> response = orderServiceClient.createOrder(orderRequestModel);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }
}



