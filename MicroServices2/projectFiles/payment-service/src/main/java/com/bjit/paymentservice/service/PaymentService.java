package com.bjit.paymentservice.service;

import com.bjit.paymentservice.model.PaymentRequestModel;
import org.springframework.http.ResponseEntity;

public interface PaymentService {

    ResponseEntity<Object>showALl();
    ResponseEntity<Object>create(PaymentRequestModel paymentRequestModel);
    ResponseEntity<Object>findByPaymentId(Long paymentId);

}
