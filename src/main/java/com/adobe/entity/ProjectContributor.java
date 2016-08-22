package com.adobe.entity;

public class ProjectContributor {
	
	private int projectId;
	private int employeeId;
	
	public ProjectContributor() {
	
	}

	public ProjectContributor(int projectId, int employeeId) {
		this.projectId = projectId;
		this.employeeId = employeeId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
}
