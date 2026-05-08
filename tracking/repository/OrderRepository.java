package com.order.tracking.repository;

import com.order.tracking.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByUserId(Long userId);
}