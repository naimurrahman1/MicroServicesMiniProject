package com.example.productapp;

import com.example.productapp.config.FeginClientsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class HelloController {

    @Autowired
    FeginClientsConfig feginClientsConfig;
    @GetMapping("/hello")
    public String Hello(){
        int count= feginClientsConfig.getCount();
        return "Hello From Product Count : "+  count;
    }

}
