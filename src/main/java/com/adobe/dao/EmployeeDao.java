package com.adobe.dao;

import java.util.List;

import com.adobe.entity.Employee;
import com.adobe.entity.Role;

public interface EmployeeDao {
	
	List<Employee> getEmployees();
	
	List<Employee> getEmployees(Role role);
	
	void addEmployee(Employee employee);
	
	Employee getEmployee(int id);
	
}
