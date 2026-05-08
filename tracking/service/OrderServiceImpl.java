package com.order.tracking.service.impl;

import com.order.tracking.entity.OrderItem;
import com.order.tracking.repository.OrderRepository;
import com.order.tracking.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repo;

    @Override
    public OrderItem createOrder(OrderItem order) {
        order.setStatus("PLACED");
        return repo.save(order);
    }

    @Override
    public OrderItem updateStatus(Long id) {

        OrderItem order = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        switch (order.getStatus()) {
            case "PLACED" -> order.setStatus("CONFIRMED");
            case "CONFIRMED" -> order.setStatus("PACKED");
            case "PACKED" -> order.setStatus("SHIPPED");
            case "SHIPPED" -> order.setStatus("DELIVERED");
            default -> throw new RuntimeException("Completed");
        }

        return repo.save(order);
    }

    @Override
    public List<OrderItem> getOrdersByUser(Long userId) {
        return repo.findByUserId(userId);
    }
}
