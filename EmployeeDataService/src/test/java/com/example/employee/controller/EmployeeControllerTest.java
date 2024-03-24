package com.example.employee.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;

@RunWith(PowerMockRunner.class)
@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

	@InjectMocks
	private EmployeeController employeeController;

	@Mock
	private EmployeeService employeeService;
	
	@Test
	public void testCreateEmployee() throws Exception {
		Employee employee = new Employee();
		employee.setFirstname("Dhanya");
		PowerMockito.when(employeeService.saveEmployee(employee)).thenReturn(employee);
		ResponseEntity<Employee> responseEntity = employeeController.createEmployee(employee);

		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals(employee, responseEntity.getBody());
	}
	
	@Test
	public void testFindAllEmployees() {
		Employee employee1 = new Employee();
		employee1.setFirstname("Dhanya");
		Employee employee2 = new Employee();
		employee2.setFirstname("Yajnadutta");
		
		List<Employee> employeeList=new ArrayList<>();
		employeeList.add(employee2);
		employeeList.add(employee1);
		
		PowerMockito.when(employeeService.getAllEmployees()).thenReturn(employeeList);
        ResponseEntity<List<Employee>> responseEntity = employeeController.findAllEmployees();
        
        // Verifying the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(employeeList, responseEntity.getBody());
	}
	
	@Test
	public void testGetEmployeeById() {
		Employee employee = new Employee();
		employee.setFirstname("Dhanya");
		employee.setId(1L);
		PowerMockito.when(employeeService.getEmployee(1L)).thenReturn(employee);
		
	      ResponseEntity<Employee> responseEntity = employeeController.getEmployeeById(1L);
	        
	        // Verifying the response
	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	        assertEquals(employee, responseEntity.getBody());
		
	}
	
	@Test
	public void testDeleteEmployeeById() {
		
		PowerMockito.when(employeeService.deleteEmployeeId(1L)).thenReturn("Employee deleted successfully");

        ResponseEntity<String> responseEntity = employeeController.deleteEmployeeById(1L);
        
        // Verifying the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Employee deleted successfully", responseEntity.getBody());
	}
	
	@Test
	public void testUpdateCourseById() {
		Employee updatedEmployee = new Employee();
		updatedEmployee.setFirstname("Dhanya");
		updatedEmployee.setId(1L);
		PowerMockito.when(employeeService.updateEmployeeById(1L, updatedEmployee)).thenReturn(updatedEmployee);

        ResponseEntity<Employee> responseEntity = employeeController.updateCourseById(1L, updatedEmployee);
        
        // Verifying the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(updatedEmployee, responseEntity.getBody());
	}

}
