package com.bjit.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequestModel {
    private Long paymentId;
    private Long orderId;
    private Long userId;
    private Long amount;
}
