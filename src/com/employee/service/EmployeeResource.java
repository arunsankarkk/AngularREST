package com.employee.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.record.Employee;

@Component
@Path("/Employee")
public class EmployeeResource {
	
	@Autowired
	public EmployeeService employeeService;
	

	@GET
	@Path("/getEmployeeDetail/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Employee getEmployeeDetails(@PathParam("id") String id) {
		Employee employee = employeeService.findEmployee(Integer.valueOf(id));
		return employee;
	}
	
	@GET
	@Path("/getAllEmployees")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = employeeService.getAllEmployees();
		return employeeList;
	}

	
	@Path("/saveEmployee")
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_JSON)
	public Employee saveEmployee(Employee employee){
		Employee savedEmployee = employeeService.saveEmployee(employee); 
		return savedEmployee;
	}
	
	@Path("/saveMultipleEmployee")
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveMultipleEmployee(List<Employee> employees){
		employeeService.saveMultipleEmployee(employees); 
		return Response.status(Status.OK).build();
	}
	
	@Path("/updateEmployee")
	@PUT
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response updateEmployee(Employee employee){
		employeeService.updateEmployee(employee); 
		return Response.status(Status.OK).build();
	}
	
	@Path("/deleteEmployee/{id}")
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	public Response deleteEmployee(@PathParam("id") String id){
		employeeService.deleteEmployee(Integer.valueOf(id)); 
		return Response.status(Status.OK).build();
	}
	
	
}
