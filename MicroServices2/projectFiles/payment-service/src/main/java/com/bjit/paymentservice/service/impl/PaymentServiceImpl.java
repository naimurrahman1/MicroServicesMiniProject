package com.bjit.paymentservice.service.impl;

import com.bjit.paymentservice.entity.PaymentEntity;
import com.bjit.paymentservice.model.PaymentRequestModel;
import com.bjit.paymentservice.repository.PaymentRepository;
import com.bjit.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;
    @Override
    public ResponseEntity<Object> showALl() {
        List<PaymentEntity> paymentList=paymentRepository.findAll();

        return new ResponseEntity<>(paymentList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> create(PaymentRequestModel paymentRequestModel) {
        PaymentEntity paymentEntity=PaymentEntity.builder()
                .orderId(paymentRequestModel.getOrderId())
                .userId(paymentRequestModel.getUserId())
                .amount(paymentRequestModel.getAmount())
                .build();
        PaymentEntity savedPaymentEntity=paymentRepository.save(paymentEntity);
        return new ResponseEntity<>(savedPaymentEntity,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> findByPaymentId(Long paymentId) {
        PaymentEntity paymentEntity=paymentRepository.findByPaymentId(paymentId);
        if(paymentEntity==null)
        {
            return  new ResponseEntity<>("Invalid Payment Data",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paymentEntity,HttpStatus.OK);
    }
}
