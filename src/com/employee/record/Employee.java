/**
 * 
 */
package com.employee.record;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Arunsankar K K
 *
 */

@XmlRootElement
@Entity
@Table(name="EMPLOYEE")
public class Employee {
	
	private Integer id;
	private String name;
	private String designation;
	private Double salary;
	
	private Address address;
	
	public Employee() {
		
	}
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="NAME", nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="DESIGNATION", nullable=false)
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Column(name="SALARY", nullable=false)
	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="doorNo", column=@Column(name="DOOR_NO")),
		@AttributeOverride(name="street", column=@Column(name="STREET")),
		@AttributeOverride(name="location", column=@Column(name="LOCATION")),
		@AttributeOverride(name="city", column=@Column(name="CITY"))
	})

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
