package com.bjit.orderservice.service;

import com.bjit.orderservice.model.OrderRequestModel;
import org.springframework.http.ResponseEntity;

public interface OrderService {

    ResponseEntity<Object>create(OrderRequestModel orderRequestModel);
    ResponseEntity<Object>showAll();
    ResponseEntity<Object>delete(Long orderId);

    ResponseEntity<Object>findByOrderId(Long orderId);
}
