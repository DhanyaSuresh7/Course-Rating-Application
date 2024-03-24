package com.example.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.entity.Employee;
import com.example.employee.exception.ResourceNotFoundException;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with given id is not found: " + id));
	}

	@Override
	public String deleteEmployeeId(Long id) {
		employeeRepository.deleteById(id);
		return "Deleted Successfully";

	}

	@Override
	public Employee updateEmployeeById(Long id, Employee updatedEmployee) {
		return employeeRepository.findById(id).map(existingEmployee -> {
			existingEmployee.setFirstname(updatedEmployee.getFirstname());
			existingEmployee.setLastname(updatedEmployee.getLastname());
			existingEmployee.setDate_of_birth(updatedEmployee.getDate_of_birth());
			existingEmployee.setDepartment(updatedEmployee.getDepartment());
			existingEmployee.setDesignation(updatedEmployee.getDesignation());
			return employeeRepository.save(existingEmployee);
		}).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
	}

}
