package com.order.tracking.service;

import com.order.tracking.entity.OrderItem;

import java.util.List;

public interface OrderService {

    OrderItem createOrder(OrderItem order);

    OrderItem updateStatus(Long id);

    List<OrderItem> getOrdersByUser(Long userId);
}