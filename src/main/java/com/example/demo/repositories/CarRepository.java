package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.realationshipTable.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{

}
