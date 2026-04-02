
package com.car.carparking.service;

import com.car.carparking.dao.Cars;
import com.car.carparking.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepo repo;

    // GET all cars
    public List<Cars> getAllCars() {
        return repo.findAll();
    }

    // CREATE car
    public Cars createCars(Cars c) {
        return repo.save(c);
    }

    // DELETE car
    public String deleteCar(int Car_id) {
        repo.deleteById(Car_id);
        return "Car deleted successfully";
    }

    // UPDATE car
    public Cars updateCar(Cars c, int Car_id) {
        Cars existing = repo.findById(Car_id).orElse(null);

        if (existing != null) {
            existing.setUser_name(c.getUser_name());
            existing.setSlot_status(c.getSlot_status());

            return repo.save(existing);
        } else {
            return null;
        }
    }
}