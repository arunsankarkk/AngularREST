package com.employee.record;

import javax.persistence.Embeddable;

/**
 * @author Arunsankar K K
 *
 */

@Embeddable
public class Address {

	private String doorNo; 
	private String street;
	private String location;
	private String city;

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
