package com.adobe.dao;

import java.util.List;

import com.adobe.entity.Project;
import com.adobe.entity.ProjectContributor;
import com.adobe.entity.ProjectDisplayItem;

public interface ProjectDao {
	
	List<ProjectDisplayItem> getProjects();
	
	Project getProject(int id);
	
	void addProject(Project project);
	
	void assignManager(ProjectContributor projectContributor);
	
	void assignEmployee(ProjectContributor contributor);
}
