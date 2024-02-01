package com.example.cassandrademo.controller;

import com.example.cassandrademo.model.Car;
import com.example.cassandrademo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carservice;

    @GetMapping()
    public ResponseEntity<List<Car>> getAllcars() {

        return new ResponseEntity<>(carservice.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") int id) {

        return new ResponseEntity<>(carservice.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Car> createCar(@RequestBody Car car) {

        return new ResponseEntity<>(carservice.saveCar(car), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") int id, @RequestBody Car car) {

        if (carservice.existById(id)) {
            return new ResponseEntity<>(carservice.saveCar(car), HttpStatus.ACCEPTED);
        }

        throw new IllegalArgumentException("Car with id " + id + "not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable("id") int id) {

        carservice.deleteCar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}