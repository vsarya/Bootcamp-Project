package com.adobe.dao;

import java.util.List;

import com.adobe.entity.Employee;
import com.adobe.entity.Project;
import com.adobe.entity.ProjectContributor;

public interface ProjectDao {
	
	List<Project> getProjects();
	
	Project getProject(int id);
	
	void addProject(Project project);
	
	void addManager(Employee manager);
	
	void assignEmployee(ProjectContributor contributor);
}
