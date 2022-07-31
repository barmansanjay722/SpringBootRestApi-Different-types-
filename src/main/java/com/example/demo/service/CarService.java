package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.realationshipTable.Car;
import com.example.demo.repositories.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	public Car createCar(Car car) {
		return carRepository.save(car);
	}
	
	public List<Car> getCarList() {
		return carRepository.findAll();
	}
	
	public Car getCarById(int id) {
		return carRepository.findById(id).orElse(null);
	}
	
	public String deleteCar(int id) {
		carRepository.deleteById(id);
		return "Car Deleted successfully";
	}
	
	public Car updateCar(Car car) {
		Optional<Car> carFound = carRepository.findById(car.getId());
		
		if(carFound.isPresent()) {
			Car carUpdate = carFound.get();
			carUpdate.setName(car.getName());
			carUpdate.setCarType(car.getCarType());
			carUpdate.setCompany(car.getCompany());
			
			return carRepository.save(carUpdate);
		}
		else {
			return null;
		}
	}
}
