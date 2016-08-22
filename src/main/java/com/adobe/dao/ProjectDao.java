package com.adobe.dao;

import java.util.List;

import com.adobe.entity.Employee;
import com.adobe.entity.Project;

public interface ProjectDao {
	
	List<Project> getProjects();
	
	Project getProject(int id);
	
	void addProject(Project project);
	
	void addManager(Employee manager);
	
	void addStaff(Employee staff);
}
