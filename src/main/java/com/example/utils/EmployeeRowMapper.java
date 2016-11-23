package com.example.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.model.Employee;

/**
 * This defines a RowMapper for Employee class RowMapper maps a row of the table
 * Employee to an object Employee and returns the object
 */                                                                

@Component
public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setName(rs.getString("name"));
		employee.setId(rs.getString("id"));
		employee.setPosition(rs.getString("position"));
		return employee;
	}
}
