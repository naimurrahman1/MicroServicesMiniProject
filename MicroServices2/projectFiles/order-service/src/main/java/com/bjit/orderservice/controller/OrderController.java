package com.bjit.orderservice.controller;

import com.bjit.orderservice.model.OrderRequestModel;
import com.bjit.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<Object> createOrder(@RequestBody OrderRequestModel orderRequestModel) {
        return orderService.create(orderRequestModel);
    }

    @GetMapping("/showAll")
    public ResponseEntity<Object> getAllOrders() {
        return orderService.showAll();
    }
//find single order
    @GetMapping("/{orderId}")
    public ResponseEntity<Object> findByOrderId(@PathVariable Long orderId) {
        return orderService.findByOrderId(orderId);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Object> deleteOrder(@PathVariable Long orderId) {
        return orderService.delete(orderId);
    }
}