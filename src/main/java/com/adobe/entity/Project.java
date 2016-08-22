package com.adobe.entity;

import java.util.List;

public class Project {

	private int id;
	private String name;
	private String clientName;
	private Employee manager;
	private List<Employee> contributors;
	
	public Project() {

	}

	public Project(int id, String name, String clientName, Employee manager, List<Employee> contributors) {
		super();
		this.id = id;
		this.name = name;
		this.clientName = clientName;
		this.manager = manager;
		this.contributors = contributors;
	}

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getClientName() {
		return clientName;
	}

	public final void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public final Employee getManager() {
		return manager;
	}

	public final void setManager(Employee manager) {
		this.manager = manager;
	}

	public final List<Employee> getContributors() {
		return contributors;
	}

	public final void setContributors(List<Employee> contributors) {
		this.contributors = contributors;
	}
	
}
