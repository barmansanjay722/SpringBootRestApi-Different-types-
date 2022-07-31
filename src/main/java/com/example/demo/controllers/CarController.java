package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.realationshipTable.Car;
import com.example.demo.response.ResponseHandler;
import com.example.demo.service.CarService;

import java.util.*;

@RestController
@RequestMapping("/api")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	
	@PostMapping("/createCar")
	public ResponseEntity<Object> addCar(@RequestBody Car car){
		
		try {
			Car result = carService.createCar(car);
			return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
		}
		catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
		}
	}
	
	@GetMapping("/getCar/{id}")
	public ResponseEntity<Object> getCar(@PathVariable int id) {
		
		try {
			Car car = carService.getCarById(id);
			return ResponseHandler.generateResponse("success", HttpStatus.OK, car);
		}
		catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS, e);
		}
	}
	
	@GetMapping("/getAllCar")
	public ResponseEntity<Object> getAllCar() {
		
		try {
			List<Car> car = carService.getCarList();
			return ResponseHandler.generateResponse("success", HttpStatus.OK, car);
		}
		catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
		}
	}
	
	@GetMapping("/deleteCar/{id}")
	public ResponseEntity<Object> deleteCar(@PathVariable int id){
		try {
			String car = carService.deleteCar(id);
			return ResponseHandler.generateResponse("Deleted", HttpStatus.OK, car);
		}
		catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
		}
	}
	
	@PutMapping("/updateCar")
	public ResponseEntity<Object> updateCar(@RequestBody Car car){
		try {
			Car result = carService.updateCar(car);
			return ResponseHandler.generateResponse("success", HttpStatus.OK, result);
		}
		catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS, e);
		}
	}
}
