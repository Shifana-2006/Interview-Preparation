package com.bill.billsystem.TextileRepo;

import com.bill.billsystem.TextileDAO.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepo extends JpaRepository<Bill, Long> {
}