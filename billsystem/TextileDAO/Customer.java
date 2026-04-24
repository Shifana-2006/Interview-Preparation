package com.bill.billsystem.TextileDAO;

import jakarta.persistence.*;
import lombok.*;

    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Customer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long cust_id;

        private String cust_name;
        private Long ph_no;
        private String location;
    }

