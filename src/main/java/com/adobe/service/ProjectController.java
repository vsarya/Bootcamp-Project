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

import com.adobe.dao.ProjectDao;
import com.adobe.entity.Project;
import com.adobe.entity.ProjectContributor;

@Controller
public class ProjectController {

	@Autowired
	private ProjectDao projectDao;
	
	@RequestMapping(value="/projects", method = RequestMethod.GET)
	public @ResponseBody List<Project> getProjects() {
		return projectDao.getProjects();
	}
	
	@RequestMapping(value="/projects", method = RequestMethod.POST)
	public ResponseEntity<String> addProject(@RequestBody Project project) {
		projectDao.addProject(project);
		return new ResponseEntity<String>("Project " + project.getName() + " added", HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/assignEmployee", method = RequestMethod.POST)
	public ResponseEntity<String> assignEmployee(@RequestBody ProjectContributor projectContributor) {
		projectDao.assignEmployee(projectContributor);
		return new ResponseEntity<String>("Employee Assigned", HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/assignManager", method = RequestMethod.POST)
	public ResponseEntity<String> assignManager(@RequestBody ProjectContributor projectContributor) {
		projectDao.assignManager(projectContributor);
		return new ResponseEntity<String>("Manager Assigned", HttpStatus.ACCEPTED);
	}
}
