package com.adobe.entity;

public class Project {

	private int id;
	private String name;
	private String clientName;
	
	public Project() {

	}

	public Project(int id, String name, String clientName) {
		super();
		this.id = id;
		this.name = name;
		this.clientName = clientName;
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

}
