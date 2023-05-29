package com.bjit.orderservice.repository;

import com.bjit.orderservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    OrderEntity findByOrderId(Long orderId);
}
