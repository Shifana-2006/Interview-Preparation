package com.bill.billsystem.TextileRepo;

import com.bill.billsystem.TextileDAO.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
