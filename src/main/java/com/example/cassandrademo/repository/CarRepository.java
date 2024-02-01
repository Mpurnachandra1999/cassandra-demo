package com.example.cassandrademo.repository;

import com.example.cassandrademo.model.Car;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends CassandraRepository<Car, Integer> {
    List<Car> findByModel(String model);
}