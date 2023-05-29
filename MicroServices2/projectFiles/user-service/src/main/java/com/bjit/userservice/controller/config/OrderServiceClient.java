package com.bjit.userservice.controller.config;

import com.bjit.userservice.model.OrderRequestModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "order-service")
public interface OrderServiceClient {
    @PostMapping("/orders/create")
    ResponseEntity<Object> createOrder(@RequestBody OrderRequestModel orderRequestModel);
}
