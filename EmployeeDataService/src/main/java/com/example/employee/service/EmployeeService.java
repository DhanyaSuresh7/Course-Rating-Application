package com.example.employee.service;

import java.util.List;

import com.example.employee.entity.Employee;

public interface EmployeeService {

	// create
	Employee saveEmployee(Employee employee);

	// get all user
	List<Employee> getAllEmployees();

	// get single user of given userId
	Employee getEmployee(Long id);

	// delete
	String deleteEmployeeId(Long id);

	// update
	Employee updateEmployeeById(Long id, Employee updatedEmployee);
}
