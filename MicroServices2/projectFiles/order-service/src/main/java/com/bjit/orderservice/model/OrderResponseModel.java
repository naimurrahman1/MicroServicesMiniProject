package com.bjit.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseModel {
    private Long orderId;
    private Long userId;
    private Long bookId;
    private Long quantity;
}
