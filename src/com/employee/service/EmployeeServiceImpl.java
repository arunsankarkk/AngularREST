package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.record.Employee;

/**
 * 
 * @author Arunsankar
 *
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeDao employeeDao;

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee = employeeDao.saveEmployee(employee);
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeDao.deleteEmployee(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = employeeDao.getAllEmployees();
		return allEmployees;
	}

	@Override
	public Employee findEmployee(Integer id) {
		Employee findEmployee = employeeDao.findEmployee(id);
		return findEmployee;
	}
	
	@Override
	public void saveMultipleEmployee(List<Employee> employees){
		employeeDao.saveMultipleEmployee(employees);
	}

}
