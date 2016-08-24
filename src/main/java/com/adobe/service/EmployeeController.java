package com.adobe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adobe.dao.EmployeeDao;
import com.adobe.entity.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping(value="/employees", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}
	
	@RequestMapping(value="/addEmployee", method = RequestMethod.POST)
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		employeeDao.addEmployee(employee);
		return new ResponseEntity<String>("Employee " + employee.getEmail() + " added", HttpStatus.CREATED);
	}
}
