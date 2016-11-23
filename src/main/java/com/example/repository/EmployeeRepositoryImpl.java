package com.example.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.stereotype.Component;

import com.example.model.Employee;
import com.example.utils.EmployeeRowMapper;

/**
 * This is the implementation of the repository methods This contains all the
 * logic that must be done when the methods are called for a particular request
 */

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {
	private static final String FIND_ALL_STMT = "select * from Employee OFFSET ? LIMIT ?";
	private static final String INSERT_STMT = "insert into Employee values(?, ?, ?)";
	private static final String FIND_BY_ID_STMT = "select * from Employee where id = ?";
	private static final String FIND_ID_BY_NAME_STMT = "select id from Employee where name = ?";

	private final JdbcOperations jdbc;
	private final SimpleJdbcInsertOperations insert;
	private final EmployeeRowMapper employeeRowMapper;

	/**
	 * This does the initialization for Jdbc operations and RowMapping
	 */
	public EmployeeRepositoryImpl(EmployeeRowMapper employeeRowMapper, DataSource ds) {
		this.jdbc = new JdbcTemplate(ds);
		this.insert = new SimpleJdbcInsert(ds).withTableName("Employee");
		this.employeeRowMapper = employeeRowMapper;
	}

	/**
	 * This has the logic to get all the employee details in Employee table
	 */
	@Override
	public List<Employee> getAllEmployees(int count) {
		List<Employee> employees = jdbc.query(FIND_ALL_STMT, new Object[] { 0, count }, employeeRowMapper);
		return employees;
	}

	/**
	 * This has the logic to add an employee details to Employee table
	 */
	@Override
	public void addEmployee(Employee employee) {
		jdbc.update(INSERT_STMT, new Object[] { employee.getName(), employee.getId(), employee.getPosition() });
	}

	/**
	 * This has the logic to get the employee detail for a particular id
	 */
	@Override
	public Employee getEmployeeById(String id) {
		Employee employee = jdbc.queryForObject(FIND_BY_ID_STMT, new Object[] { id }, employeeRowMapper);
		return employee;
	}

	/**
	 * This has the logic to get the id of employee with the given name
	 */
	@Override
	public String getEmployeeIdByName(String name) {
		String id = jdbc.queryForObject(FIND_ID_BY_NAME_STMT, String.class, name);
		return id;
	}
}
