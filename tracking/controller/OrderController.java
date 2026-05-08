package com.order.tracking.controller;

import com.order.tracking.entity.OrderItem;
import com.order.tracking.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public OrderItem create(@RequestBody OrderItem order) {
        return service.createOrder(order);
    }

    @PutMapping("/{id}")
    public OrderItem update(@PathVariable Long id) {
        return service.updateStatus(id);
    }

    @GetMapping("/user/{userId}")
    public List<OrderItem> getByUser(@PathVariable Long userId) {
        return service.getOrdersByUser(userId);
    }
}