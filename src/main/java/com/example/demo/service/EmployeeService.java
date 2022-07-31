package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee craateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	public String deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		
		return "Employee "+id+ " deleted";
	}
	
	public Employee updateEmployee(Employee employee) {
		
		Optional<Employee> emplyeeFound = employeeRepository.findById(employee.getId());
		
		if(emplyeeFound.isPresent()) {
			Employee employeeUpdate = emplyeeFound.get();
			employeeUpdate.setName(employee.getName());
			employeeUpdate.setAddress(employee.getAddress());
			employeeUpdate.setEmpId(employee.getEmpId());
			
			return employeeRepository.save(employee);
		}
		else {
			return null;
		}
	}
	
}
