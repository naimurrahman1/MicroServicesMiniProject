package com.bjit.orderservice.service.impl;

import com.bjit.orderservice.entity.OrderEntity;
import com.bjit.orderservice.model.OrderRequestModel;
import com.bjit.orderservice.repository.OrderRepository;
import com.bjit.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public ResponseEntity<Object> create(OrderRequestModel orderRequestModel) {
        OrderEntity orderEntity=OrderEntity.builder()
                .bookId(orderRequestModel.getBookId())
                .userId(orderRequestModel.getUserId())
                .quantity(orderRequestModel.getQuantity())
                .build();
        OrderEntity savedOrderEntity=orderRepository.save(orderEntity);
        return new ResponseEntity<>(savedOrderEntity, HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<Object> showAll() {
        List<OrderEntity> orderList=orderRepository.findAll();

        return new ResponseEntity<>(orderList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> delete(Long orderId) {
        OrderEntity orderEntity=orderRepository.findByOrderId(orderId);
        if(orderEntity==null)
        {
            return new ResponseEntity<>("Order not found",HttpStatus.NOT_FOUND);

        }
        orderRepository.deleteById(orderId);
        return new ResponseEntity<>("Order Cancelled Successfully",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> findByOrderId(Long orderId) {
        OrderEntity orderEntity=orderRepository.findByOrderId(orderId);
        if(orderEntity==null)
        {
            return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderEntity, HttpStatus.OK);
    }
}
