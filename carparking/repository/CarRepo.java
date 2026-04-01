package com.car.carparking.repository;

import com.car.carparking.dao.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface CarRepo extends JpaRepository<Cars,Integer> {

    }
