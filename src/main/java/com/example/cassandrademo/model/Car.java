package com.example.cassandrademo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Table
@Getter
@Setter
public class Car {
    /*@PrimaryKey
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;*/

    @PrimaryKey
    @Column(name="id")
    private int id;

    @Column(name="model")
    private String model;
    @Column(name="description")
    private String description;
    @Column(name="color")
    private String color;
}