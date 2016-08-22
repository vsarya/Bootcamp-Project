package com.adobe.entity;

public class Employee {
	
	private int id;
	private String fName, lName;
	private String email;
	private Double salary;
	private Role role;
	
	public Employee() {
		
	}

	public Employee(int id, String fName, String lName, String email, Double salary, Role role) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.salary = salary;
		this.role = role;
	}

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getfName() {
		return fName;
	}

	public final void setfName(String fName) {
		this.fName = fName;
	}

	public final String getlName() {
		return lName;
	}

	public final void setlName(String lName) {
		this.lName = lName;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final Double getSalary() {
		return salary;
	}

	public final void setSalary(Double salary) {
		this.salary = salary;
	}

	public final Role getRole() {
		return role;
	}

	public final void setType(Role role) {
		this.role = role;
	}	
}
