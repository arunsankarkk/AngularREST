package com.employee.dao;

import java.util.List;

import com.employee.record.Employee;
/**
 * 
 * @author Arunsankar
 *
 */
public interface EmployeeDao {

	
	public List<Employee> getAllEmployees();
	
	public Employee findEmployee(Integer id);
	
	public Employee saveEmployee(Employee employee);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(Integer id);
	
	public void saveMultipleEmployee(List<Employee> employees);

}
