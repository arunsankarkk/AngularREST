package com.employee.service;

import java.util.List;

import com.employee.record.Employee;

/**
 * 
 * @author Arunsankar
 *
 */

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Employee findEmployee(Integer id);
	
	public Employee saveEmployee(Employee employee);
	
	public void saveMultipleEmployee(List<Employee> employees);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(Integer id);
	
}
