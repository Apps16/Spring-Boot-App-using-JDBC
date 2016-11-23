package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import org.springframework.boot.actuate.health.Health;
//import org.springframework.boot.actuate.health.HealthIndicator;
//import org.springframework.boot.actuate.metrics.*;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

/**
 * Controller class that handles all GET and POST requests
 */

@RestController
@RequestMapping("employee")
public class EmployeeController {

	private EmployeeRepository empRepo;

	@Autowired
	public EmployeeController(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}
	
	/**
	 * This handles GET /employee 
	 * It returns all the employee details
	 */
	@GetMapping
	public List<Employee> getAllEmployees() {
		return empRepo.getAllEmployees(Integer.MAX_VALUE);
	}

	/**
	 * This handles POST /employee
	 * It adds an employee detail given in the request body to the Employee table
	 */
	@PostMapping
	public Employee addEmployee(@RequestBody @Validated Employee employee) {
		empRepo.addEmployee(employee);
		return employee;
	}

	/**
	 * This handles GET /employee/get?id=<give the id of employee>
	 * This returns the employee detail with the given id
	 */
	@GetMapping("/get")
	public Employee getEmployeeById(@RequestParam("id") String id) {
		return empRepo.getEmployeeById(id);
	}

	/**
	 * This handles GET /employee/getid?name=<give the full name of an employee>
	 * This returns the employee id who has the given full name
	 */
	@GetMapping("/getid")
	public String getEmployeeIdByName(@RequestParam("name") String name) {
		return empRepo.getEmployeeIdByName(name);
	}
}
