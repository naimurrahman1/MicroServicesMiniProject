package com.bjit.paymentservice.repository;

import com.bjit.paymentservice.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity,Long> {

    PaymentEntity findByPaymentId(Long paymentId);
}
