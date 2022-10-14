package com.imageinnovate.Imageinnovate.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeID")
	
	public Long EmployeeID;
	
	@NotBlank(message = "FirstName is mandatory")
	@Column(name = "FirstName")
	public String FirstName;
	
	@NotBlank(message = "LastName is mandatory")
	@Column(name = "LastName")
	public String LastName;
	
	@Column(name = "PhoneNumber")
	public Long[] PhoneNumber;
	
	@Column(name = "DOJ")
	public Date DOJ;
	
	@Column(name = "Salary")
	public Double Salary;

	public Long getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(Long employeeID) {
		EmployeeID = employeeID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Long[] getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(Long[] phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public Date getDOJ() {
		return DOJ;
	}

	public void setDOJ(Date dOJ) {
		DOJ = dOJ;
	}

	public Double getSalary() {
		return Salary;
	}

	public void setSalary(Double salary) {
		Salary = salary;
	}

	public Employee(Long employeeID, String firstName, String lastName, Long[] phoneNumber, Date dOJ,
			Double salary) {
		super();
		EmployeeID = employeeID;
		FirstName = firstName;
		LastName = lastName;
		PhoneNumber = phoneNumber;
		DOJ = dOJ;
		Salary = salary;
	}

	public Employee() {
		super();
	}	

}
