package com.example.cassandrademo.service;

import com.example.cassandrademo.model.Car;
import com.example.cassandrademo.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CarService {

    private final CarRepository carRepository;

    public List<Car> findAll() {

        return carRepository.findAll();
    }

    public Car findById(int id) {
        return carRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(int id) {

        carRepository.deleteById(id);
    }

    public Car updateCar(Car car) {
        return carRepository.save(car);
    }

    public boolean existById(int id) {
        return carRepository.existsById(id);
    }
}