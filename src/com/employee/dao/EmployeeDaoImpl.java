package com.employee.dao;

import java.util.List;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employee.record.Employee;

/**
 * 
 * @author Arunsankar
 *
 */
@Repository
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {

	
	@Override
	@Transactional
	public Employee saveEmployee(Employee employee) {
		save(employee);
		return employee;
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		update(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		delete(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = getAll();
		return employeeList;
	}

	@Override
	public Employee findEmployee(Integer id) {
		Employee emp = find(id);
		return emp;
	}

	public void saveMultipleEmployee(List<Employee> employees){
		saveAllRecord(employees);
	}
	
}
