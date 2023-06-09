package com.example.productapp.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "payment-app")
public interface FeginClientsConfig {

    @GetMapping("/getCount")
    public Integer getCount();
}