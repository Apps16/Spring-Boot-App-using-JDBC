package com.example.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.model.Employee;

/**
 * This declares all user-defined methods of a repository These methods are
 * implemented in EmployeeRepositoryImpl
 */

@Component
public interface EmployeeRepository {

	List<Employee> getAllEmployees(int count);

	void addEmployee(Employee employee);

	Employee getEmployeeById(String id);

	String getEmployeeIdByName(String name);
}
