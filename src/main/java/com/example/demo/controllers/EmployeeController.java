package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.response.ResponseHandler;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping("/createEmployee")
	public ResponseEntity<Object> createEmployeee(@RequestBody Employee employee) {
		
		try {
			Employee result = employeeService.craateEmployee(employee);
			
			return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
		}catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}
	
	@GetMapping("/getAllEmployee")
	public ResponseEntity<Object> getAllEmployee() {
		try {
			List<Employee> result = employeeService.getAllEmployee();
			
			return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
		}catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}
	
	@GetMapping("/getEmaployee/{id}")
	public ResponseEntity<Object> getEmployee(@PathVariable int id) {
		
		try {
			Employee employee = employeeService.getEmployeeById(id);
			
			return ResponseHandler.generateResponse("Success", HttpStatus.OK, employee);
		}catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable int id) {
		
		try {
			String result = employeeService.deleteEmployee(id);
			
			return ResponseHandler.generateResponse("Deleted", HttpStatus.OK, result);
		}catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}
	
	@PostMapping("/updateEmplyee/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		
		try {
			Employee employee2 = employeeService.updateEmployee(employee);
			
			return ResponseHandler.generateResponse("Deleted", HttpStatus.OK, employee2);
		}catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}
}
