package com.bjit.paymentservice.controller;

import com.bjit.paymentservice.model.PaymentRequestModel;
import com.bjit.paymentservice.service.PaymentService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;


    @GetMapping("/showAll")
    public ResponseEntity<Object> getAllPayments() {
        return paymentService.showALl();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createPayment(@RequestBody PaymentRequestModel paymentRequestModel) {
        return paymentService.create(paymentRequestModel);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Object> findPaymentById(@PathVariable Long paymentId) {
        return paymentService.findByPaymentId(paymentId);
    }
}
